package ojt.clinic.app.web.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReceptionistForm {
    private Integer userId;
    @NotEmpty
    @Size(min = 3, max = 30)
    @Pattern(regexp = "^[a-zA-Z_ ]*$")
    private String userName;
    @NotEmpty
    @Email
    private String userEmail;
    @NotEmpty
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")
    private String userPassword;
    @NotEmpty
    @Pattern(regexp = "(^&|[0-9,]{9,})")
    private String userPhone;
}