package ojt.bookstore.app.persistence.dao.book.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ojt.bookstore.app.persistence.dao.book.BookDao;
import ojt.bookstore.app.persistence.entity.Book;

/**
 * <h2>BookDaoImpl Class</h2>
 * <p>
 * Process for Displaying BookDaoImpl
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
@Repository
public class BookDaoImpl implements BookDao {
    /**
     * <h2>sessionFactory</h2>
     * <p>
     * sessionFactory
     * </p>
     */
    @Autowired
    private SessionFactory sessionFactory;
    /**
     * <h2>SELECT_BOOK_HQL</h2>
     * <p>
     * SELECT_BOOK_HQL
     * </p>
     */
    private static final String SELECT_BOOK_HQL = "SELECT " + "b " + "FROM Book b ";

    /**
     * <h2>dbAddBook</h2>
     * <p>
     * Add New Book
     * </p>
     * 
     * @param book Book
     */
    @Override
    public void dbAddBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(book);
    }

    /**
     * <h2>dbListBooks</h2>
     * <p>
     * Show All Books
     * </p>
     * 
     * @return List<Book>
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Book> dbListBooks() {
        return this.sessionFactory.getCurrentSession().createQuery(SELECT_BOOK_HQL).list();
    }

    /**
     * <h2>dbGetBookById</h2>
     * <p>
     * Get Book By ID
     * </p>
     * 
     * @param id int
     * @return
     */
    @SuppressWarnings("removal")
    @Override
    public Book dbGetBookById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = (Book) session.get(Book.class, new Integer(id));
        return book;
    }

    /**
     * <h2>dbUpdateBook</h2>
     * <p>
     * Update Book
     * </p>
     * 
     * @param book Book
     */
    @Override
    public void dbUpdateBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.update(book);
    }

    /**
     * <h2>dbUpdateQuan</h2>
     * <p>
     * Update Book Quantity
     * </p>
     * 
     * @param id   int
     * @param quan int
     */
    @Override
    public void dbUpdateQuan(int id, int quan) {
        sessionFactory.getCurrentSession().createQuery("UPDATE Book set Quantity=" + quan + " where id=" + id)
                .executeUpdate();
    }
}