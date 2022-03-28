package ojt.clinic.app.config;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import ojt.clinic.app.persistence.dao.user.UserDao;
import ojt.clinic.app.persistence.entity.User;

@Component
public class DeploymentListener {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserDao userDao;

    @PostConstruct
    public void addInitialData() {
        Date date = new Date();

        if (this.userDao.dbListUsers("ROLE_ADMIN").size() <= 0) {
            System.out.println("\n\n\n\n\n\nSize is " + userDao.dbListUsers("ROLE_ADMIN").size());
            User admin = new User();
            admin.setCreatedAt(date);
            admin.setDelFlag(0);
            admin.setUpdatedAt(date);
            admin.setUserEmail("admin@gmail.com");
            admin.setUserName("Admin");
            admin.setUserPassword(passwordEncoder.encode("Sider123$"));
            admin.setUserPhone("09123456789");
            admin.setUserType("ROLE_ADMIN");
            this.userDao.dbAddUser(admin);
        }
    }
}
