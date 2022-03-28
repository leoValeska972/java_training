package ojt.clinic.app.persistence.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ojt.clinic.app.web.form.PatientInfoForm;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PatientInfo")
public class PatientInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Integer patientId;
    @Column(name = "patient_name")
    private String patientName;
    @Column(name = "patient_age")
    private Integer patientAge;
    @Column(name = "patient_gender")
    private String patientGender;
    @Column(name = "patient_address")
    private String patientAddress;
    @Column(name = "patient_phone")
    private String patientPhone;
    @Column(name = "del_flag")
    private Integer delFlag;
    @Column(name = "date")
    private LocalDate today;
    @Column(name = "status")
    private String status;
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
    @OneToMany(mappedBy = "patientInfo")
    private List<PatientMedicalRecord> pmrs;

    public PatientInfo(PatientInfoForm patientInfoForm) {
        super();
        this.patientId = patientInfoForm.getPatientId();
        this.patientName = patientInfoForm.getPatientName();
        this.patientAge = patientInfoForm.getPatientAge();
        this.patientGender = patientInfoForm.getPatientGender();
        this.patientAddress = patientInfoForm.getPatientAddress();
        this.patientPhone = patientInfoForm.getPatientPhone();
    }
}
