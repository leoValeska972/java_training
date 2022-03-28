package ojt.clinic.app.persistence.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ojt.clinic.app.web.form.PatientMedicalRecordForm;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PatientMedicalRecord")
public class PatientMedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_medical_record_id")
    private Integer patientMedicalRecordId;
    @Column(name = "patient_id")
    private Integer patientId;
    @Column(name = "record_date_time", nullable = false, updatable = false)
    private Date recordDateTime;
    @Column(name = "medical_record")
    private String medicalRecord;
    @Column(name = "medicine")
    private String medicine;
    @Column(name = "cost")
    private Integer cost;
    @Column(name = "remark")
    private String remark;
    @Column(name = "del_flag")
    private Integer delFlag;
    @Column(name = "created_user_id")
    private Integer createdUserId;
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;
    @Column(name = "updated_user_id")
    private Integer updatedUserId;
    @Column(name = "updated_at")
    private Date updatedAt;
    @Column(name = "deleted_user_id")
    private Integer deletedUserId;
    @Column(name = "deleted_at")
    private Date deletedAt;
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false, insertable = false, updatable = false)
    private PatientInfo patientInfo;

    public PatientMedicalRecord(PatientMedicalRecordForm patientMedicalRecordForm) {
        super();
        this.patientMedicalRecordId = patientMedicalRecordForm.getPatientMedicalRecordId();
        this.patientId = patientMedicalRecordForm.getPatientId();
        this.medicalRecord = patientMedicalRecordForm.getMedicalRecord();
        this.medicine = patientMedicalRecordForm.getMedicine();
        this.cost = patientMedicalRecordForm.getCost();
        this.remark = patientMedicalRecordForm.getRemark();
    }
}
