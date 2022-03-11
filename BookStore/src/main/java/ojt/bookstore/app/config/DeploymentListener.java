package ojt.bookstore.app.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import ojt.bookstore.app.persistence.dao.user.UserDao;
import ojt.bookstore.app.persistence.entity.User;

/**
 * <h2>DeploymentListener Class</h2>
 * <p>
 * Process for Displaying DeploymentListener
 * </p>
 * 
 * @author ZawLwinTun
 *
 */
@Component
public class DeploymentListener {

    /**
     * <h2>passwordEncoder</h2>
     * <p>
     * passwordEncoder
     * </p>
     */
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * <h2>userDao</h2>
     * <p>
     * userDao
     * </p>
     */
    @Autowired
    private UserDao userDao;

    /**
     * <h2>addInitialData</h2>
     * <p>
     * Add Initial Data
     * </p>
     *
     * @return void
     */
    @PostConstruct
    public void addInitialData() {

        if (this.userDao.dbGetUserCount() <= 0) {
            User admin = new User(null, "manager", passwordEncoder.encode("123"), "ROLE_Manager");
            this.userDao.dbSaveUser(admin);

            User user = new User(null, "casher", passwordEncoder.encode("123"), "ROLE_Casher");
            this.userDao.dbSaveUser(user);
        }
    }
}
