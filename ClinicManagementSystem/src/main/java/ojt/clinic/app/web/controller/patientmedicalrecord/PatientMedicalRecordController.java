package ojt.clinic.app.web.controller.patientmedicalrecord;

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
import ojt.clinic.app.bl.service.patientmedicalrecord.PatientMedicalRecordService;
import ojt.clinic.app.web.form.PatientMedicalRecordForm;

@Controller
public class PatientMedicalRecordController {
    private ModelAndView mv;
    @Autowired
    private PatientMedicalRecordService patientMedicalRecordService;

    @Autowired
    private PatientInfoService patientInfoService;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private HttpSession session;

    @RequestMapping(value = "/addPatientMedicalRecordConfirm", method = RequestMethod.POST)
    public ModelAndView addPatientMedicalRecordConfirm(
            @Valid @ModelAttribute("patientMedicalRecordForm") PatientMedicalRecordForm patientMedicalRecordForm,
            BindingResult br) {
        mv = new ModelAndView();
        if (br.hasErrors()) {
            if (patientMedicalRecordForm.getPatientMedicalRecordId() == null
                    || patientMedicalRecordForm.getPatientMedicalRecordId() == 0) {
                mv.addObject("btnName", "Clear");
                mv.addObject("btnJs", "clear");
            } else {
                mv.addObject("btnName", "Reset");
                mv.addObject("btnJs", "reset");
            }
            mv.setViewName("patientMedicalRecord");
        } else {
            mv.setViewName("confirm");
            mv.addObject("name",
                    patientInfoService.doGetPatientInfoById(patientMedicalRecordForm.getPatientId()).getPatientName());
            mv.addObject("res", "patientMedicalRecord");
        }
        return mv;
    }

    @RequestMapping(value = "/addPatientMedicalRecord", method = RequestMethod.POST)
    public ModelAndView addPatientMedicalRecord(
            @Valid @ModelAttribute("patientMedicalRecordForm") PatientMedicalRecordForm patientMedicalRecordForm) {
        mv = new ModelAndView("redirect:/medicalRecordView/" + patientMedicalRecordForm.getPatientId());
        if (patientMedicalRecordForm.getPatientMedicalRecordId() == null
                || patientMedicalRecordForm.getPatientMedicalRecordId() == 0) {
            patientMedicalRecordService.doAddPatientMedicalRecord(patientMedicalRecordForm);
            session.setAttribute("msg", messageSource.getMessage("M_SC_0001", null, null));
        } else {
            patientMedicalRecordService.doUpdatePatientMedicalRecord(patientMedicalRecordForm);
            session.setAttribute("msg", messageSource.getMessage("M_SC_0003", null, null));
        }
        return mv;
    }

    @RequestMapping("/addPatientMedicalRecord/{id}")
    public ModelAndView addPatientMedicalRecordById(@PathVariable("id") int id) {
        mv = new ModelAndView("patientMedicalRecord");
        PatientMedicalRecordForm patientMedicalRecordForm = new PatientMedicalRecordForm();
        patientMedicalRecordForm.setPatientId(id);
        mv.addObject("patientMedicalRecordForm", patientMedicalRecordForm);
        mv.addObject("btnName", "Clear");
        mv.addObject("btnJs", "clear");
        return mv;
    }

    @RequestMapping(value = "/medicalRecordView", method = RequestMethod.GET)
    public ModelAndView medicalRecordView() {
        ModelAndView mv = new ModelAndView("patientMedicalRecordView");
        mv.addObject("patientMedicalRecordList", patientMedicalRecordService.doListPatientMedicalRecords());
        mv.addObject("all", "all");
        return mv;
    }

    @RequestMapping("/medicalRecordView/{id}")
    public ModelAndView medicalRecordViewById(@PathVariable("id") int id) {
        mv = new ModelAndView("patientMedicalRecordView");
        session.setAttribute("pid", id);
        mv.addObject("pid", id);
        mv.addObject("name", patientInfoService.doGetPatientInfoById(id).getPatientName());
        mv.addObject("age", patientInfoService.doGetPatientInfoById(id).getPatientAge());
        mv.addObject("gender", patientInfoService.doGetPatientInfoById(id).getPatientGender());
        mv.addObject("patientMedicalRecordList", patientMedicalRecordService.doListPatientMedicalRecordsByPid(id));
        return mv;
    }

    @RequestMapping(value = "/recordSearch", method = RequestMethod.POST)
    public ModelAndView recordSearch(@RequestParam("record") String record) {
        int pid = (int) session.getAttribute("pid");
        mv = new ModelAndView("patientMedicalRecordView");
        mv.addObject("patientMedicalRecordList",
                patientMedicalRecordService.doSearchListPatientMedicalRecords(pid, record));
        int count = patientMedicalRecordService.doSearchListPatientMedicalRecords(pid, record).size();
        mv.addObject("msg", count + " results found");
        mv.addObject("name", patientInfoService.doGetPatientInfoById(pid).getPatientName());
        mv.addObject("age", patientInfoService.doGetPatientInfoById(pid).getPatientAge());
        mv.addObject("gender", patientInfoService.doGetPatientInfoById(pid).getPatientGender());
        return mv;
    }

    @RequestMapping(value = "/recordSearchAll", method = RequestMethod.POST)
    public ModelAndView recordSearchAll(@RequestParam("record") String record) {
        mv = new ModelAndView("patientMedicalRecordView");
        mv.addObject("patientMedicalRecordList",
                patientMedicalRecordService.doSearchAllListPatientMedicalRecords(record));
        int count = patientMedicalRecordService.doSearchAllListPatientMedicalRecords(record).size();
        mv.addObject("msg", count + " results found");
        mv.addObject("all", "all");
        return mv;
    }

    @RequestMapping("/editPatientMedicalRecord/{id}")
    public ModelAndView editPatientMedicalRecord(@PathVariable("id") int id) {
        mv = new ModelAndView("patientMedicalRecord");
        mv.addObject("btnName", "Reset");
        mv.addObject("btnJs", "reset");
        mv.addObject("patientMedicalRecordForm", patientMedicalRecordService.doGetPatientMedicalRecordById(id));
        return mv;
    }

    @RequestMapping("/deletePatientMedicalRecord/{id}")
    public String deletePatientMedicalRecord(@PathVariable("id") int id) {
        session.setAttribute("msg", this.messageSource.getMessage("M_SC_0002", null, null));
        patientMedicalRecordService.doDeletePatientMedicalRecord(id);
        return "redirect:/medicalRecordView/"
                + patientMedicalRecordService.doGetPatientMedicalRecordById(id).getPatientId();
    }
}
