package ojt.clinic.app.bl.service.Receptionist;

import java.util.List;

import ojt.clinic.app.bl.dto.UserDTO;
import ojt.clinic.app.web.form.ReceptionistForm;

public interface ReceptionistService {
    public void doAddReceptionist(ReceptionistForm receptionistForm);

    public List<UserDTO> doListReceptionists(String type);

    public List<UserDTO> doSearchListReceptionists(String search, String type);

    public UserDTO doGetReceptionistById(int id);

    public void doUpdateReceptionist(ReceptionistForm receptionistForm);

    public void doDeleteReceptionist(int id);
}
