package ojt.clinic.app.web.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientMedicalRecordForm {
    private Integer patientMedicalRecordId;
    private Integer patientId;

    @NotEmpty
    private String medicalRecord;

    @NotEmpty
    private String medicine;

    @NotNull
    private Integer cost;
    private String remark;
}
