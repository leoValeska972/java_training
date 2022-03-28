package ojt.clinic.app.persistence.dao.patientinfo;

import java.time.LocalDate;
import java.util.List;

import ojt.clinic.app.persistence.entity.PatientInfo;

public interface PatientInfoDao {
    public void dbAddPatientInfo(PatientInfo patientInfo);
    
    public void dbAddTodayPatient(LocalDate today, int id);

    public List<PatientInfo> dbListPatientInfos();

    public List<PatientInfo> dbSearchListPatientInfos(String search);

    public List<PatientInfo> dbTodayPatients(LocalDate today,String status);

    public PatientInfo dbGetPatientInfoById(int id);

    public void dbUpdatePatientInfo(PatientInfo patientInfo);

    public void dbChangeStatus(int id);

    public void dbDeletePatientInfo(int id);
}
