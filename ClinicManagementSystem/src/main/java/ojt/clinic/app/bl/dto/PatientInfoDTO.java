package ojt.clinic.app.bl.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ojt.clinic.app.persistence.entity.PatientInfo;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientInfoDTO {
    private Integer patientId;
    private String patientName;
    private Integer patientAge;
    private String patientGender;
    private String patientAddress;
    private String patientPhone;
    private LocalDate today;
    private String status;

    public PatientInfoDTO(PatientInfo patientInfo) {
        super();
        this.patientId = patientInfo.getPatientId();
        this.patientName = patientInfo.getPatientName();
        this.patientAge = patientInfo.getPatientAge();
        this.patientGender = patientInfo.getPatientGender();
        this.patientAddress = patientInfo.getPatientAddress();
        this.patientPhone = patientInfo.getPatientPhone();
        this.today=patientInfo.getToday();
        this.status=patientInfo.getStatus();
    }
}
