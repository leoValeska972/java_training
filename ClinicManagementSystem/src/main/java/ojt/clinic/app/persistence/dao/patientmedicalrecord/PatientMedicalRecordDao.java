package ojt.clinic.app.persistence.dao.patientmedicalrecord;

import java.util.List;

import ojt.clinic.app.persistence.entity.PatientMedicalRecord;

public interface PatientMedicalRecordDao {
    public void dbAddPatientMedicalRecord(PatientMedicalRecord patientMedicalRecord);

    public List<PatientMedicalRecord> dbListPatientMedicalRecords();

    public List<PatientMedicalRecord> dbListPatientMedicalRecordsByPid(int id);

    public List<PatientMedicalRecord> dbSearchListPatientMedicalRecords(int id, String record);

    public List<PatientMedicalRecord> dbSearchAllListPatientMedicalRecords(String record);

    public PatientMedicalRecord dbGetPatientMedicalRecordById(int id);

    public void dbUpdatePatientMedicalRecord(PatientMedicalRecord patientMedicalRecord);

    public void dbDeletePatientMedicalRecord(int id);
}
