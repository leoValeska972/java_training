package ojt.clinic.app.bl.service.Receptionist.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ojt.clinic.app.bl.dto.UserDTO;
import ojt.clinic.app.bl.service.Receptionist.ReceptionistService;
import ojt.clinic.app.persistence.dao.user.UserDao;
import ojt.clinic.app.persistence.entity.User;
import ojt.clinic.app.web.form.ReceptionistForm;

@Service
@Transactional
public class ReceptionistServiceImpl implements ReceptionistService {

    @Autowired
    private UserDao userDao;

    @Override
    public void doAddReceptionist(ReceptionistForm receptionistForm) {
        User receptionist = new User(receptionistForm);
        Date a = new Date();
        receptionist.setUserType("ROLE_RECEPTIONIST");
        receptionist.setDelFlag(0);
        receptionist.setUpdatedAt(a);
        userDao.dbAddUser(receptionist);
    }

    @Override
    public List<UserDTO> doListReceptionists(String type) {
        List<UserDTO> receptionistList = new ArrayList<UserDTO>();
        for (User receptionist : this.userDao.dbListUsers(type)) {
            UserDTO receptionistDto = new UserDTO(receptionist);
            receptionistList.add(receptionistDto);
        }
        return receptionistList;
    }

    @Override
    public List<UserDTO> doSearchListReceptionists(String search, String Type) {
        List<UserDTO> receptionistList = new ArrayList<UserDTO>();
        for (User receptionist : this.userDao.dbSearchListUsers(search, "ROLE_RECEPTIONIST")) {
            UserDTO receptionistDto = new UserDTO(receptionist);
            receptionistList.add(receptionistDto);
        }
        return receptionistList;
    }

    @Override
    public UserDTO doGetReceptionistById(int id) {
        User receptionist = this.userDao.dbGetUserById(id);
        UserDTO receptionistForm = receptionist != null ? new UserDTO(receptionist) : null;
        return receptionistForm;
    }

    @Override
    public void doUpdateReceptionist(ReceptionistForm receptionistForm) {
        User receptionist = new User(receptionistForm);
        Date a = new Date();
        receptionist.setUserType("ROLE_RECEPTIONIST");
        receptionist.setDelFlag(0);
        receptionist.setUpdatedAt(a);
        userDao.dbUpdateUser(receptionist);
    }

    @Override
    public void doDeleteReceptionist(int id) {
        Date a = new Date();
        userDao.dbGetUserById(id).setDeletedAt(a);
        userDao.dbDeleteUser(id);
    }
}

