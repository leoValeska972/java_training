package ojt.bookstore.app.persistence.dao.sellbook.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ojt.bookstore.app.persistence.dao.sellbook.SellBookDao;
import ojt.bookstore.app.persistence.entity.SellBook;

/**
 * <h2>SellBookDaoImpl Class</h2>
 * <p>
 * Process for Displaying SellBookDaoImpl
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
@Repository
public class SellBookDaoImpl implements SellBookDao {
    /**
     * <h2>sessionFactory</h2>
     * <p>
     * sessionFactory
     * </p>
     */
    @Autowired
    private SessionFactory sessionFactory;
    /**
     * <h2>SELECT_SELLBOOK_HQL</h2>
     * <p>
     * SELECT_SELLBOOK_HQL
     * </p>
     */
    private static final String SELECT_SELLBOOK_HQL = "SELECT " + "sb " + "FROM SellBook sb ";

    /**
     * <h2>dbAddSellBook</h2>
     * <p>
     * Add Sold Book
     * </p>
     * 
     * @param sb SellBook
     */
    @Override
    public void dbAddSellBook(SellBook sb) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(sb);
    }

    /**
     * <h2>dbListSellBooks</h2>
     * <p>
     * Show Sold Books
     * </p>
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<SellBook> dbListSellBooks() {
        return this.sessionFactory.getCurrentSession().createQuery(SELECT_SELLBOOK_HQL).list();
    }

    /**
     * <h2>dbGetSellBookById</h2>
     * <p>
     * Get Sold Book By ID
     * </p>
     * 
     * @param id int
     * @return
     */
    @SuppressWarnings("removal")
    @Override
    public SellBook dbGetSellBookById(int id) {
        Session session = sessionFactory.getCurrentSession();
        SellBook sb = (SellBook) session.get(SellBook.class, new Integer(id));
        return sb;
    }

    /**
     * <h2>dbUpdateSellBook</h2>
     * <p>
     * Update Sold Book
     * </p>
     * 
     * @param sb SellBook
     */
    @Override
    public void dbUpdateSellBook(SellBook sb) {
        Session session = sessionFactory.getCurrentSession();
        session.update(sb);
    }
}
