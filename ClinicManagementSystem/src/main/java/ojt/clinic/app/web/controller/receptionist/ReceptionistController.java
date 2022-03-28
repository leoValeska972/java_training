package ojt.clinic.app.web.controller.receptionist;

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

import ojt.clinic.app.bl.service.Receptionist.ReceptionistService;
import ojt.clinic.app.bl.service.user.UserService;
import ojt.clinic.app.web.form.ReceptionistForm;

@Controller
public class ReceptionistController {

    private ModelAndView mv;
    @Autowired
    private ReceptionistService receptionistService;
    @Autowired
    private UserService userService;
    @Autowired
    private MessageSource messageSource;

    @Autowired
    private HttpSession session;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/error")
    public String error() {
        return "access-denied";
    }

    @RequestMapping("/receptionistInit")
    public ModelAndView receptionistRegistrationPage() {
        mv = new ModelAndView("receptionist");
        mv.addObject("receptionistForm", new ReceptionistForm());
        mv.addObject("btnName", "Clear");
        mv.addObject("btnJs", "clear");
        return mv;
    }

    @RequestMapping(value = "/addReceptionistConfirm", method = RequestMethod.POST)
    public ModelAndView addReceptionistConfirm(
            @Valid @ModelAttribute("receptionistForm") ReceptionistForm receptionistForm, BindingResult br) {
        mv = new ModelAndView();
        boolean isEmailExist = userService.doCheckEmail(receptionistForm.getUserEmail());
        if (br.hasErrors() || isEmailExist == true) {
            if (receptionistForm.getUserId() == null || receptionistForm.getUserId() == 0) {
                mv.addObject("btnName", "Clear");
                mv.addObject("btnJs", "clear");
            } else {
                mv.addObject("btnName", "Reset");
                mv.addObject("btnJs", "reset");
            }
            if (isEmailExist == true) {
                mv.addObject("msg", "Email already exists");
            }
            mv.setViewName("receptionist");
        } else {
            mv.setViewName("confirm");
            mv.addObject("res", "receptionist");
        }
        return mv;
    }

    @RequestMapping(value = "/addReceptionist", method = RequestMethod.POST)
    public ModelAndView addReceptionist(@ModelAttribute("receptionistForm") ReceptionistForm recepForm) {
        ModelAndView mv = new ModelAndView("redirect:/receptionistView");
        if (recepForm.getUserId() == null || recepForm.getUserId() == 0) {
            receptionistService.doAddReceptionist(recepForm);
            session.setAttribute("msg", messageSource.getMessage("M_SC_0001", null, null));
        } else {
            receptionistService.doUpdateReceptionist(recepForm);
            session.setAttribute("msg", messageSource.getMessage("M_SC_0003", null, null));
        }
        return mv;
    }

    @RequestMapping("/receptionistView")
    public ModelAndView receptionistView() {
        mv = new ModelAndView("receptionistView");
        mv.addObject("receptionistList", receptionistService.doListReceptionists("ROLE_RECEPTIONIST"));
        return mv;
    }

    @RequestMapping(value = "/receptionistSearch", method = RequestMethod.POST)
    public ModelAndView receptionistSearch(@RequestParam("search") String search) {
        ModelAndView mv = new ModelAndView("receptionistView");
        mv.addObject("receptionistList", receptionistService.doSearchListReceptionists(search, "ROLE_RECEPTIONIST"));
        int count = receptionistService.doSearchListReceptionists(search, "ROLE_RECEPTIONIST").size();
        mv.addObject("msg", count + " results found");
        return mv;
    }

    @RequestMapping("/editReceptionist/{id}")
    public ModelAndView editReceptionist(@PathVariable("id") Integer id) {
        mv = new ModelAndView("receptionist");
        mv.addObject("receptionistForm", receptionistService.doGetReceptionistById(id));
        mv.addObject("btnName", "Reset");
        mv.addObject("btnJs", "reset");
        return mv;
    }

    @RequestMapping("deleteReceptionist/{id}")
    public ModelAndView deleteReceptionist(@PathVariable("id") Integer id) {
        mv = new ModelAndView("redirect:/receptionistView");
        receptionistService.doDeleteReceptionist(id);
        session.setAttribute("msg", messageSource.getMessage("M_SC_0002", null, null));
        return mv;
    }
}
