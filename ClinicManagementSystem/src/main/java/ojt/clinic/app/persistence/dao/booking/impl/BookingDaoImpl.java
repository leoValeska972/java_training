package ojt.clinic.app.persistence.dao.booking.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ojt.clinic.app.persistence.dao.booking.BookingDao;
import ojt.clinic.app.persistence.entity.Booking;

@Repository
public class BookingDaoImpl implements BookingDao {
    @Autowired
    private SessionFactory sessionFactory;
    private static final String SELECT_BOOKING_HQL = "SELECT b FROM Booking b WHERE b.delFlag = 0 ";
    private static final String SEARCH_BOOKING_HQL = "SELECT b FROM Booking b WHERE (b.patientName like :search AND b.delFlag = 0) OR (b.bookingDate like :search AND b.delFlag = 0) OR (b.status like :search AND b.delFlag = 0) OR (b.rejectMsg like :search AND b.delFlag = 0) OR (b.contactPhone like :search AND b.delFlag = 0) OR (b.patientGender  like :search AND b.delFlag = 0)";
    private static final String DELETE_BOOKING_HQL = "UPDATE Booking b set b.delFlag = 1  where b.bookingId = :bid";

    @Override
    public void dbAddBooking(Booking booking) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(booking);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Booking> dbListBookings() {
        return this.sessionFactory.getCurrentSession().createQuery(SELECT_BOOKING_HQL).list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Booking> dbSearchListBookings(String search) {
        return this.sessionFactory.getCurrentSession().createQuery(SEARCH_BOOKING_HQL)
                .setParameter("search", "%" + search + "%").list();
    }

    @SuppressWarnings("removal")
    @Override
    public Booking dbGetBookingById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Booking booking = (Booking) session.get(Booking.class, new Integer(id));
        return booking;
    }

    @Override
    public void dbUpdateBooking(Booking booking) {
        Session session = sessionFactory.getCurrentSession();
        session.update(booking);
    }

    @Override
    public void dbDeleteBooking(int id) {
        sessionFactory.getCurrentSession().createQuery(DELETE_BOOKING_HQL).setParameter("bid", id).executeUpdate();
    }
}