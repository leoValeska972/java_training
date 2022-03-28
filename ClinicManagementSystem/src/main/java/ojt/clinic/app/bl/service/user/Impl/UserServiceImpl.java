package ojt.clinic.app.bl.service.user.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ojt.clinic.app.bl.dto.UserAuthorityDetail;
import ojt.clinic.app.bl.service.user.UserService;
import ojt.clinic.app.persistence.dao.user.UserDao;
import ojt.clinic.app.persistence.entity.User;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserDao userDao;

    @Override
    public User doGetUserByEmail(String email) {
        return this.userDao.dbGetUserByEmail(email);
    }

    @Override
    public boolean doCheckEmail(String email) {
        boolean isExist=false;
        for(int i=0;i<userDao.dbListUsers("ROLE_%").size();i++) {
            if(userDao.dbListUsers("ROLE_%").get(i).getUserEmail().equals(email)) {
                isExist=true;
            }
        }
        return isExist;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userInfo = this.userDao.dbGetUserByEmail(username);
        if (userInfo == null) {
            throw new UsernameNotFoundException("Invalid Username or Password!");
        }
        UserDetails user = new UserAuthorityDetail(userInfo.getUserEmail(), userInfo.getUserPassword(),
                userInfo.getUserType());
        return user;
    }
}
