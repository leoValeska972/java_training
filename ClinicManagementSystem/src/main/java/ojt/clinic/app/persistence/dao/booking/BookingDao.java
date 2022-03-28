package ojt.clinic.app.persistence.dao.booking;

import java.util.List;

import ojt.clinic.app.persistence.entity.Booking;

public interface BookingDao {
    public void dbAddBooking(Booking booking);

    public List<Booking> dbListBookings();

    public List<Booking> dbSearchListBookings(String search);

    public Booking dbGetBookingById(int id);

    public void dbUpdateBooking(Booking booking);

    public void dbDeleteBooking(int id);

}
