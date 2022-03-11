package ojt.bookstore.app.persistence.dao.user.impl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ojt.bookstore.app.persistence.dao.user.UserDao;
import ojt.bookstore.app.persistence.entity.User;

/**
 * <h2>UserDaoImpl Class</h2>
 * <p>
 * Process for Displaying UserDaoImpl
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
@Transactional
@Repository
public class UserDaoImpl implements UserDao {

    /**
     * <h2>sessionFactory</h2>
     * <p>
     * sessionFactory
     * </p>
     */
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * <h2>SELECT_USER_HQL</h2>
     * <p>
     * SELECT_USER_HQL
     * </p>
     */
    private static final String SELECT_USER_HQL = "SELECT u FROM User u WHERE u.uname= :uname";
    /**
     * <h2>SELECT_USERCOUNT_HQL</h2>
     * <p>
     * SELECT_USERCOUNT_HQL
     * </p>
     */
    private static final String SELECT_USERCOUNT_HQL = "SELECT COUNT(u) FROM User u";

    /**
     * <h2>dbSaveUser</h2>
     * <p>
     * Insert User
     * </p>
     * 
     * @param user User
     */
    @Override
    public void dbSaveUser(User user) {
        this.sessionFactory.getCurrentSession().save(user);
    }

    /**
     * <h2>dbGetUserByName</h2>
     * <p>
     * Get User By Name
     * </p>
     * 
     * @param username
     * @return
     */
    @SuppressWarnings("rawtypes")
    @Override
    public User dbGetUserByName(String username) {
        Query query = this.sessionFactory.getCurrentSession().createQuery(SELECT_USER_HQL).setParameter("uname",
                username);
        return (User) query.uniqueResult();
    }

    /**
     * <h2>dbGetUserCount</h2>
     * <p>
     * Get User Number
     * </p>
     * 
     * @return
     */
    @SuppressWarnings("rawtypes")
    @Override
    public long dbGetUserCount() {
        Query query = this.sessionFactory.getCurrentSession().createQuery(SELECT_USERCOUNT_HQL);
        return (long) query.getSingleResult();
    }
}