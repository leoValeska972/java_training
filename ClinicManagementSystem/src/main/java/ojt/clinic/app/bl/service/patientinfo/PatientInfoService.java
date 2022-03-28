package ojt.clinic.app.bl.service.patientinfo;

import java.time.LocalDate;
import java.util.List;

import ojt.clinic.app.bl.dto.PatientInfoDTO;
import ojt.clinic.app.web.form.PatientInfoForm;

public interface PatientInfoService {
    public void doAddPatientInfo(PatientInfoForm patientInfoFrom);
    
    public void doAddTodayPatient(LocalDate today, int id);

    public List<PatientInfoDTO> doListPatientInfos();
    
    public List<PatientInfoDTO> doSearchListPatientInfos(String search);
    
    public List<PatientInfoDTO> doTodayPatients(LocalDate today,String status);

    public PatientInfoDTO doGetPatientInfoById(int id);

    public void doUpdatePatientInfo(PatientInfoForm patientInfoForm);

    public void doChangeStatus(int id);

    public void doDeletePatientInfo(int id);

}
