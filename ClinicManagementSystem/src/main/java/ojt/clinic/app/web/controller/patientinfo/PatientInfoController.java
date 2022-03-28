package ojt.clinic.app.web.controller.patientinfo;

import java.time.LocalDate;

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

import ojt.clinic.app.bl.service.patientinfo.PatientInfoService;
import ojt.clinic.app.web.form.PatientInfoForm;

@Controller
public class PatientInfoController {
    private ModelAndView mv;
    @Autowired
    private PatientInfoService patientInfoService;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private HttpSession session;

    @RequestMapping(value = "/patientInit", method = RequestMethod.GET)
    public ModelAndView patientInit() {
        mv = new ModelAndView("patientInfo");
        mv.addObject("patientInfoForm", new PatientInfoForm());
        mv.addObject("btnName", "Clear");
        mv.addObject("btnJs", "clear");
        return mv;
    }

    @RequestMapping(value = "/addPatientInfoConfirm", method = RequestMethod.POST)
    public ModelAndView addPatientInfoConfirm(@Valid @ModelAttribute("patientInfoForm") PatientInfoForm patientInfoForm,
            BindingResult br) {
        mv = new ModelAndView();
        if (br.hasErrors()) {
            if (patientInfoForm.getPatientId() == null || patientInfoForm.getPatientId() == 0) {
                mv.addObject("btnName", "Clear");
                mv.addObject("btnJs", "clear");
            } else {
                mv.addObject("btnName", "Reset");
                mv.addObject("btnJs", "reset");
            }
            mv.setViewName("patientInfo");
        } else {
            mv.setViewName("confirm");
            mv.addObject("res", "patientInfo");
        }
        return mv;
    }

    @RequestMapping(value = "/addPatientInfo", method = RequestMethod.POST)
    public ModelAndView addPatientInfo(@ModelAttribute("patientInfoForm") PatientInfoForm patientInfoForm) {
        mv = new ModelAndView("redirect:/patientInfoView");
        if (patientInfoForm.getPatientId() == null || patientInfoForm.getPatientId() == 0) {
            patientInfoService.doAddPatientInfo(patientInfoForm);
            session.setAttribute("msg", messageSource.getMessage("M_SC_0001", null, null));
        } else {
            patientInfoService.doUpdatePatientInfo(patientInfoForm);
            session.setAttribute("msg", messageSource.getMessage("M_SC_0003", null, null));
        }
        return mv;
    }

    @RequestMapping(value = "/patientInfoView", method = RequestMethod.GET)
    public ModelAndView patientInfoView() {
        mv = new ModelAndView("patientInfoView");
        mv.addObject("today",LocalDate.now());
        mv.addObject("patientInfoList", patientInfoService.doListPatientInfos());
        return mv;
    }

    @RequestMapping(value = "/patientInfoSearch", method = RequestMethod.POST)
    public ModelAndView patientInfoSearch(@RequestParam("search") String search) {
        mv = new ModelAndView("patientInfoView");
        mv.addObject("patientInfoList", patientInfoService.doSearchListPatientInfos(search));
        int count = patientInfoService.doSearchListPatientInfos(search).size();
        mv.addObject("msg", count + " results found");
        return mv;
    }

    @RequestMapping(value = "/todayPatientView", method = RequestMethod.GET)
    public ModelAndView todayPatientView() {
        mv = new ModelAndView("todayPatientView");
        mv.addObject("treatingPatient", patientInfoService.doTodayPatients(LocalDate.now(),"Treating"));
        mv.addObject("finishedPatient", patientInfoService.doTodayPatients(LocalDate.now(),"Finished"));
        return mv;
    }

    @RequestMapping(value = "/addTodayPatient/{id}", method = RequestMethod.GET)
    public ModelAndView addTodayPatient(@PathVariable("id") int id) {
        mv = new ModelAndView("redirect:/patientInfoView");
        mv.addObject("patientInfoList", patientInfoService.doListPatientInfos());
        patientInfoService.doAddTodayPatient(LocalDate.now(), id);
        return mv;
    }

    @RequestMapping(value = "/changeStatus/{id}", method = RequestMethod.GET)
    public ModelAndView changeStatus(@PathVariable("id") int id) {
        mv = new ModelAndView("redirect:/todayPatientView");
        patientInfoService.doChangeStatus(id);
        return mv;
    }

    @RequestMapping("/editPatientInfo/{id}")
    public ModelAndView editPatientInfo(@PathVariable("id") int id) {
        mv = new ModelAndView("patientInfo");
        mv.addObject("btnName", "Reset");
        mv.addObject("btnJs", "reset");
        mv.addObject("patientInfoForm", patientInfoService.doGetPatientInfoById(id));
        return mv;
    }

    @RequestMapping("/deletePatientInfo/{id}")
    public String deletePatientInfo(@PathVariable("id") int id) {
        session.setAttribute("msg", this.messageSource.getMessage("M_SC_0002", null, null));
        patientInfoService.doDeletePatientInfo(id);
        return "redirect:/patientInfoView";
    }
}
