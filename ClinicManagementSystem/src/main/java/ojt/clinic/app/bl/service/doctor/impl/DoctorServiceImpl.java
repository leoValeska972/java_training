package ojt.clinic.app.bl.service.doctor.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ojt.clinic.app.bl.dto.UserDTO;
import ojt.clinic.app.bl.service.doctor.DoctorService;
import ojt.clinic.app.persistence.dao.user.UserDao;
import ojt.clinic.app.persistence.entity.User;
import ojt.clinic.app.web.form.DoctorForm;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private UserDao userDao;

    @Override
    public void doAddDoctor(DoctorForm doctorForm) {
        User doctor = new User(doctorForm);
        Date a = new Date();
        doctor.setUserType("ROLE_DOCTOR");
        doctor.setDelFlag(0);
        doctor.setUpdatedAt(a);
        userDao.dbAddUser(doctor);
    }

    @Override
    public List<UserDTO> doListDoctors(String type) {
        List<UserDTO> doctorList = new ArrayList<UserDTO>();
        for (User doctor : this.userDao.dbListUsers(type)) {
            UserDTO doctorDto = new UserDTO(doctor);
            doctorList.add(doctorDto);
        }
        return doctorList;
    }

    @Override
    public List<UserDTO> doSearchListDoctors(String search, String type) {
        List<UserDTO> doctorList = new ArrayList<UserDTO>();
        for (User doctor : this.userDao.dbSearchListUsers(search, type)) {
            UserDTO doctorDto = new UserDTO(doctor);
            doctorList.add(doctorDto);
        }
        return doctorList;
    }

    @Override
    public UserDTO doGetDoctorById(int id) {
        User doctor = this.userDao.dbGetUserById(id);
        UserDTO doctorForm = doctor != null ? new UserDTO(doctor) : null;
        return doctorForm;
    }

    @Override
    public void doUpdateDoctor(DoctorForm doctorForm) {
        User doctor = new User(doctorForm);
        Date a = new Date();
        doctor.setDelFlag(0);
        doctor.setUpdatedAt(a);
        userDao.dbUpdateUser(doctor);
    }

    @Override
    public void doDeleteDoctor(int id) {
        Date a = new Date();
        userDao.dbGetUserById(id).setDeletedAt(a);
        userDao.dbDeleteUser(id);
    }
}
