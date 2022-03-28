package ojt.clinic.app.bl.service.patientmedicalrecord;

import java.util.List;

import ojt.clinic.app.bl.dto.PatientMedicalRecordDTO;
import ojt.clinic.app.web.form.PatientMedicalRecordForm;

public interface PatientMedicalRecordService {
    public void doAddPatientMedicalRecord(PatientMedicalRecordForm patientMedicalRecordFrom);

    public List<PatientMedicalRecordDTO> doListPatientMedicalRecords();

    public List<PatientMedicalRecordDTO> doListPatientMedicalRecordsByPid(int id);

    public List<PatientMedicalRecordDTO> doSearchListPatientMedicalRecords(int id, String record);

    public List<PatientMedicalRecordDTO> doSearchAllListPatientMedicalRecords(String record);

    public PatientMedicalRecordDTO doGetPatientMedicalRecordById(int id);

    public void doUpdatePatientMedicalRecord(PatientMedicalRecordForm patientMedicalRecordForm);

    public void doDeletePatientMedicalRecord(int id);
}
