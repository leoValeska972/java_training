package ojt.clinic.app.bl.service.doctor;

import java.util.List;

import ojt.clinic.app.bl.dto.UserDTO;
import ojt.clinic.app.web.form.DoctorForm;

public interface DoctorService {
    public void doAddDoctor(DoctorForm doctorForm);

    public List<UserDTO> doListDoctors(String type);

    public List<UserDTO> doSearchListDoctors(String search, String type);

    public UserDTO doGetDoctorById(int id);

    public void doUpdateDoctor(DoctorForm doctorForm);

    public void doDeleteDoctor(int id);
}
