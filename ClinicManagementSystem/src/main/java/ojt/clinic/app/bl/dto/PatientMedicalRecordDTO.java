package ojt.clinic.app.bl.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ojt.clinic.app.persistence.entity.PatientMedicalRecord;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientMedicalRecordDTO {
    private Integer patientMedicalRecordId;
    private Integer patientId;
    private String patientName;
    private Date recordDateTime;
    private String medicalRecord;
    private String medicine;
    private Integer cost;
    private String remark;

    public PatientMedicalRecordDTO(PatientMedicalRecord patientMedicalRecord) {
        super();
        this.patientMedicalRecordId = patientMedicalRecord.getPatientMedicalRecordId();
        this.patientId=patientMedicalRecord.getPatientId();
        this.patientName=patientMedicalRecord.getPatientInfo().getPatientName();
        this.recordDateTime = patientMedicalRecord.getRecordDateTime();
        this.medicalRecord = patientMedicalRecord.getMedicalRecord();
        this.medicine = patientMedicalRecord.getMedicine();
        this.cost = patientMedicalRecord.getCost();
        this.remark = patientMedicalRecord.getRemark();
    }
}
