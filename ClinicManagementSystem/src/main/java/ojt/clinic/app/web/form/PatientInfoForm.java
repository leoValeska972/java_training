package ojt.clinic.app.web.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientInfoForm {
    private Integer patientId;
    @NotEmpty
    @Size(min=3,max = 30)
    @Pattern(regexp = "^[a-zA-Z_ ]*$")
    private String patientName;
    @NotNull
    @Max(value = 100)
    private Integer patientAge;
    @NotEmpty
    private String patientGender;
    @NotEmpty
    @Size(max = 100)
    private String patientAddress;
    @NotEmpty
    @Pattern(regexp = "(^&|[0-9,]{9,})")
    private String patientPhone;
    private String status;
}
