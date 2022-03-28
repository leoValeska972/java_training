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
import ojt.clinic.app.web.form.BookingForm;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Integer bookingId;
    @Column(name = "patient_name")
    private String patientName;
    @Column(name = "contact_phone")
    private String contactPhone;
    @Column(name = "patient_Gender")
    private String patientGender;
    @Column(name = "doctor_id")
    private Integer doctorId;
    @Column(name = "booking_date")
    private Date bookingDate;
    @Column(name = "pending_status")
    private String status;
    @Column(name = "reject_msg")
    private String rejectMsg;
    @Column(name = "del_flag")
    private Integer delFlag;
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;
    @Column(name = "deleted_at")
    private Date deletedAt;
    
    public Booking(BookingForm bookingForm) {
        super();
        this.bookingId = bookingForm.getBookingId();
        this.patientName = bookingForm.getPatientName();
        this.contactPhone = bookingForm.getContactPhone();
        this.patientGender=bookingForm.getPatientGender();
        this.status=bookingForm.getStatus();
        this.rejectMsg=bookingForm.getRejectMsg();
    }
}
