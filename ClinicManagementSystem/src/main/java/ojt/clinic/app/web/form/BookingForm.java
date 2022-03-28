package ojt.clinic.app.web.form;

import javax.validation.constraints.NotEmpty;
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
public class BookingForm {
    private Integer bookingId;
    @NotEmpty
    @Size(min=3,max = 30)
    @Pattern(regexp = "^[a-zA-Z_ ]*$")
    private String patientName;
    @NotEmpty
    @Pattern(regexp = "(^&|[0-9,]{9,})")
    private String contactPhone;
    @NotEmpty
    private String patientGender;
    private String status;
    private String rejectMsg;
}
