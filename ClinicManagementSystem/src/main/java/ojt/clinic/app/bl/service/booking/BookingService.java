package ojt.clinic.app.bl.service.booking;

import java.util.List;

import ojt.clinic.app.bl.dto.BookingDTO;
import ojt.clinic.app.web.form.BookingForm;

public interface BookingService {
    public void doAddBooking(BookingForm bookingFrom);

    public List<BookingDTO> doListBookings();

    public List<BookingDTO> doSearchListBookings(String search);

    public BookingDTO doGetBookingById(int id);

    public void doUpdateBooking(BookingForm bookingForm);

    public void doDeleteBooking(int id);

}
