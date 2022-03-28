package ojt.clinic.app.bl.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ojt.clinic.app.persistence.entity.Booking;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {
    private Integer bookingId;
    private String patientName;
    private String contactPhone;
    private String patientGender;
    private Date bookingDate;
    private String status;
    private String rejectMsg;
    private Integer doctorId;

    public BookingDTO(Booking booking) {
        super();
        this.bookingId = booking.getBookingId();
        this.patientName = booking.getPatientName();
        this.contactPhone = booking.getContactPhone();
        this.patientGender = booking.getPatientGender();
        this.bookingDate = booking.getBookingDate();
        this.status = booking.getStatus();
        this.doctorId = booking.getDoctorId();
        this.rejectMsg = booking.getRejectMsg();
    }
}
