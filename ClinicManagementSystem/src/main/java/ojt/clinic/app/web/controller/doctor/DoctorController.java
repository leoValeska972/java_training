package ojt.clinic.app.web.controller.doctor;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ojt.clinic.app.bl.service.doctor.DoctorService;
import ojt.clinic.app.bl.service.user.UserService;
import ojt.clinic.app.web.form.DoctorForm;

@Controller
public class DoctorController {
    private ModelAndView mv;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private UserService userService;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    HttpSession session;

    @RequestMapping("/doctorInit")
    public ModelAndView doctorRegistrationPage() {
        mv = new ModelAndView("doctor");
        mv.addObject("doctorForm", new DoctorForm());
        mv.addObject("btnName", "Clear");
        mv.addObject("btnJs", "clear");
        return mv;
    }

    @RequestMapping(value = "/addDoctorConfirm", method = RequestMethod.POST)
    public ModelAndView saveOrUpdateDoctor(@Valid @ModelAttribute("doctorForm") DoctorForm doctorForm,
            BindingResult br) {
        mv = new ModelAndView();
        boolean isEmailExist = userService.doCheckEmail(doctorForm.getUserEmail());
        if (br.hasErrors() || isEmailExist == true) {
            if (doctorForm.getUserId() == null || doctorForm.getUserId() == 0) {
                mv.addObject("btnName", "Clear");
                mv.addObject("btnJs", "clear");
            } else {
                mv.addObject("btnName", "Reset");
                mv.addObject("btnJs", "reset");
            }
            if (isEmailExist == true) {
                mv.addObject("msg", "Email already exists");
            }
            mv.setViewName("doctor");
        } else {
            mv.setViewName("confirm");
            mv.addObject("res", "doctor");
        }
        return mv;
    }

    @RequestMapping(value = "/addDoctor", method = RequestMethod.POST)
    public ModelAndView addDoctor(@ModelAttribute("doctorForm") DoctorForm doctorForm) {
        ModelAndView mv = new ModelAndView("redirect:/doctorView");
        if (doctorForm.getUserId() == null || doctorForm.getUserId() == 0) {
            doctorService.doAddDoctor(doctorForm);
            session.setAttribute("msg", messageSource.getMessage("M_SC_0001", null, null));
        } else {
            doctorService.doUpdateDoctor(doctorForm);
            session.setAttribute("msg", messageSource.getMessage("M_SC_0003", null, null));
        }
        return mv;
    }

    @RequestMapping("/doctorView")
    public ModelAndView doctorViewPage() {
        mv = new ModelAndView("doctorView");
        mv.addObject("title", "All Doctors");
        mv.addObject("doctorList", doctorService.doListDoctors("ROLE_DOCTOR"));
        return mv;
    }

    @RequestMapping(value = "/doctorSearch", method = RequestMethod.POST)
    public ModelAndView searchDoctor(@RequestParam("search") String search) {
        ModelAndView mv = new ModelAndView("doctorView");
        mv.addObject("doctorList", doctorService.doSearchListDoctors(search, "ROLE_DOCTOR"));
        int count = doctorService.doSearchListDoctors(search, "ROLE_DOCTOR").size();
        mv.addObject("msg", count + " results found");
        return mv;
    }

    @RequestMapping("/editDoctor/{id}")
    public ModelAndView editDoctor(@PathVariable("id") Integer id) {
        mv = new ModelAndView("doctor");
        mv.addObject("doctorForm", doctorService.doGetDoctorById(id));
        mv.addObject("btnName", "Reset");
        mv.addObject("btnJs", "reset");
        return mv;
    }

    @RequestMapping("deleteDoctor/{id}")
    public ModelAndView deleteDoctor(@PathVariable("id") Integer id) {
        mv = new ModelAndView("redirect:/doctorView");
        doctorService.doDeleteDoctor(id);
        session.setAttribute("msg", messageSource.getMessage("M_SC_0002", null, null));
        return mv;
    }
}
