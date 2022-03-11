package ojt.bookstore.app.bl.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ojt.bookstore.app.bl.dto.UserDTO;
import ojt.bookstore.app.bl.service.user.UserService;
import ojt.bookstore.app.persistence.dao.user.UserDao;
import ojt.bookstore.app.persistence.entity.User;

/**
 * <h2>UserServiceImpl Class</h2>
 * <p>
 * Process for Displaying UserServiceImpl
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    /**
     * <h2>userDao</h2>
     * <p>
     * userDao
     * </p>
     */
    @Autowired
    private UserDao userDao;

    /**
     * <h2>doGetUserByName</h2>
     * <p>
     * Get User By Name
     * </p>
     * 
     * @param username String
     * @return
     */
    @Override
    public User doGetUserByName(String username) {
        return this.userDao.dbGetUserByName(username);
    }

    /**
     * <h2>doGetUserCount</h2>
     * <p>
     * Get User Number
     * </p>
     * 
     * @return
     */
    @Override
    public long doGetUserCount() {
        return this.userDao.dbGetUserCount();
    }

    /**
     * <h2>loadUserByUsername</h2>
     * <p>
     * Load User By Username
     * </p>
     * 
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userInfo = this.userDao.dbGetUserByName(username);
        if (userInfo == null) {
            throw new UsernameNotFoundException("Invalid Username or Password!");
        }
        UserDetails user = new UserDTO(userInfo.getUname(), userInfo.getUpass(), userInfo.getUrole());
        return user;
    }
}
