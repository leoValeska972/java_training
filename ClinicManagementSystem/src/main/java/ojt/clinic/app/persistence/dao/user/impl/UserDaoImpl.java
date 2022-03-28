package ojt.clinic.app.persistence.dao.user.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ojt.clinic.app.persistence.dao.user.UserDao;
import ojt.clinic.app.persistence.entity.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;
    private static final String SELECT_USER_HQL = "SELECT u FROM User u WHERE u.delFlag = 0 AND u.userType like :uType ";
    private static final String SEARCH_USER_HQL = "SELECT u FROM User u WHERE (u.userName like :search AND u.userType= :utype AND u.delFlag=0) OR (u.userEmail like :search AND u.userType= :utype AND u.delFlag=0) OR (u.userPhone like :search AND u.userType= :utype AND u.delFlag=0) ";
    private static final String DELETE_USER_HQL = "UPDATE User u set u.delFlag = 1  where u.userId = :uid";
    private static final String SELECT_USER_EMAIL_HQL = "SELECT u FROM User u WHERE u.delFlag = 0 AND u.userEmail = :uEmail";

    @Override
    public void dbAddUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> dbListUsers(String type) {
        return this.sessionFactory.getCurrentSession().createQuery(SELECT_USER_HQL).setParameter("uType", type).list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> dbSearchListUsers(String search, String type) {
        return this.sessionFactory.getCurrentSession().createQuery(SEARCH_USER_HQL)
                .setParameter("search", "%" + search + "%").setParameter("utype", type).list();
    }

    @SuppressWarnings("removal")
    @Override
    public User dbGetUserById(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, new Integer(id));
        return user;
    }

    @Override
    public User dbGetUserByEmail(String email) {
        return (User) this.sessionFactory.getCurrentSession().createQuery(SELECT_USER_EMAIL_HQL)
                .setParameter("uEmail", email).uniqueResult();
    }

    @Override
    public void dbUpdateUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    public void dbDeleteUser(int id) {
        sessionFactory.getCurrentSession().createQuery(DELETE_USER_HQL).setParameter("uid", id).executeUpdate();
    }
}