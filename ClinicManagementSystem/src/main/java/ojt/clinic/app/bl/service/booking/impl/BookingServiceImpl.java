package ojt.clinic.app.bl.service.booking.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ojt.clinic.app.bl.dto.BookingDTO;
import ojt.clinic.app.bl.service.booking.BookingService;
import ojt.clinic.app.persistence.dao.booking.BookingDao;
import ojt.clinic.app.persistence.entity.Booking;
import ojt.clinic.app.web.form.BookingForm;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingDao bookingDao;

    @Override
    public void doAddBooking(BookingForm bookingForm) {
        Booking booking = new Booking(bookingForm);
        Date a = new Date();
        booking.setDelFlag(0);
        booking.setUpdatedAt(a);
        booking.setBookingDate(a);
        booking.setStatus("Pending");
        bookingDao.dbAddBooking(booking);
    }

    @Override
    public List<BookingDTO> doListBookings() {
        List<BookingDTO> bookingList = new ArrayList<BookingDTO>();
        for (Booking booking : this.bookingDao.dbListBookings()) {
            BookingDTO bookingDto = new BookingDTO(booking);
            bookingList.add(bookingDto);
        }
        return bookingList;
    }

    @Override
    public List<BookingDTO> doSearchListBookings(String search) {
        List<BookingDTO> bookingList = new ArrayList<BookingDTO>();
        for (Booking booking : this.bookingDao.dbSearchListBookings(search)) {
            BookingDTO bookingDto = new BookingDTO(booking);
            bookingList.add(bookingDto);
        }
        return bookingList;
    }

    @Override
    public BookingDTO doGetBookingById(int id) {
        Booking booking = this.bookingDao.dbGetBookingById(id);
        BookingDTO bookingForm = booking != null ? new BookingDTO(booking) : null;
        return bookingForm;
    }

    @Override
    public void doUpdateBooking(BookingForm bookingForm) {
        Booking booking = new Booking(bookingForm);
        Date a = new Date();
        booking.setDelFlag(0);
        booking.setUpdatedAt(a);
        bookingDao.dbUpdateBooking(booking);
    }

    @Override
    public void doDeleteBooking(int id) {
        Date a = new Date();
        bookingDao.dbGetBookingById(id).setDeletedAt(a);
        bookingDao.dbDeleteBooking(id);
    }
}
