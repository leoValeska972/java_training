package ojt.clinic.app.persistence.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ojt.clinic.app.web.form.DoctorForm;
import ojt.clinic.app.web.form.ReceptionistForm;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Column(name = "doctor_photo")
    private String doctorPhoto;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "user_password")
    private String userPassword;
    @Column(name = "user_type")
    private String userType;
    @Column(name = "doctor_degree")
    private String doctorDegree;
    @Column(name = "doctor_specialization")
    private String doctorSpecialization;
    @Column(name = "doctor_duty_day")
    private String doctorDutyDay;
    @Column(name = "doctor_duty_time")
    private String doctorDutyTime;
    @Column(name = "user_phone")
    private String userPhone;
    @Column(name = "del_flag")
    private Integer delFlag;
    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;
    @Column(name = "deleted_at")
    private Date deletedAt;

    public User(DoctorForm doctorForm) {
        super();
        this.userId = doctorForm.getUserId();
        this.doctorPhoto=doctorForm.getDoctorPhoto();
        this.userName = doctorForm.getUserName();
        this.userEmail = doctorForm.getUserEmail();
        this.userPassword = doctorForm.getUserPassword();
        this.doctorDegree = doctorForm.getDoctorDegree();
        this.doctorSpecialization = doctorForm.getDoctorSpecialization();
        this.doctorDutyDay = doctorForm.getDoctorDutyDay();
        this.doctorDutyTime = doctorForm.getDoctorDutyTime();
        this.userPhone = doctorForm.getUserPhone();
    }

    public User(ReceptionistForm receptionistForm) {
        super();
        this.userId = receptionistForm.getUserId();
        this.userName = receptionistForm.getUserName();
        this.userEmail = receptionistForm.getUserEmail();
        this.userPassword = receptionistForm.getUserPassword();
        this.userPhone = receptionistForm.getUserPhone();
    }
}
