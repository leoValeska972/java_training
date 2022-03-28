package ojt.clinic.app.bl.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ojt.clinic.app.persistence.entity.User;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Integer userId;
    private String doctorPhoto;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String doctorDegree;
    private String doctorSpecialization;
    private String doctorDutyDay;
    private String doctorDutyTime;
    private String userPhone;

    public UserDTO(User user) {
        super();
        this.userId = user.getUserId();
        this.doctorPhoto=user.getDoctorPhoto();
        this.userName = user.getUserName();
        this.userPassword = user.getUserPassword();
        this.userEmail = user.getUserEmail();
        this.doctorDegree = user.getDoctorDegree();
        this.doctorSpecialization = user.getDoctorSpecialization();
        this.doctorDutyDay = user.getDoctorDutyDay();
        this.doctorDutyTime = user.getDoctorDutyTime();
        this.userPhone = user.getUserPhone();
    }
}
