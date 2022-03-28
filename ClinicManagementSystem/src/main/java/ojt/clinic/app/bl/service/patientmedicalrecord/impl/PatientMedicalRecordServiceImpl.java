package ojt.clinic.app.bl.service.patientmedicalrecord.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ojt.clinic.app.bl.dto.PatientMedicalRecordDTO;
import ojt.clinic.app.bl.service.patientmedicalrecord.PatientMedicalRecordService;
import ojt.clinic.app.persistence.dao.patientmedicalrecord.PatientMedicalRecordDao;
import ojt.clinic.app.persistence.entity.PatientMedicalRecord;
import ojt.clinic.app.web.form.PatientMedicalRecordForm;

@Service
@Transactional
public class PatientMedicalRecordServiceImpl implements PatientMedicalRecordService {

    @Autowired
    private PatientMedicalRecordDao patientMedicalRecordDao;

    @Override
    public void doAddPatientMedicalRecord(PatientMedicalRecordForm patientMedicalRecordForm) {
        PatientMedicalRecord patientMedicalRecord = new PatientMedicalRecord(patientMedicalRecordForm);
        Date a = new Date();
        patientMedicalRecord.setDelFlag(0);
        patientMedicalRecord.setUpdatedAt(a);
        patientMedicalRecord.setRecordDateTime(a);
        patientMedicalRecordDao.dbAddPatientMedicalRecord(patientMedicalRecord);
    }

    @Override
    public List<PatientMedicalRecordDTO> doListPatientMedicalRecords() {
        List<PatientMedicalRecordDTO> patientMedicalRecordList = new ArrayList<PatientMedicalRecordDTO>();
        for (PatientMedicalRecord patientMedicalRecord : this.patientMedicalRecordDao.dbListPatientMedicalRecords()) {
            PatientMedicalRecordDTO patientMedicalRecordDto = new PatientMedicalRecordDTO(patientMedicalRecord);
            patientMedicalRecordList.add(patientMedicalRecordDto);
        }
        return patientMedicalRecordList;
    }

    @Override
    public List<PatientMedicalRecordDTO> doListPatientMedicalRecordsByPid(int id) {
        List<PatientMedicalRecordDTO> patientMedicalRecordList = new ArrayList<PatientMedicalRecordDTO>();
        for (PatientMedicalRecord patientMedicalRecord : this.patientMedicalRecordDao
                .dbListPatientMedicalRecordsByPid(id)) {
            PatientMedicalRecordDTO patientMedicalRecordDto = new PatientMedicalRecordDTO(patientMedicalRecord);
            patientMedicalRecordList.add(patientMedicalRecordDto);
        }
        return patientMedicalRecordList;
    }

    @Override
    public List<PatientMedicalRecordDTO> doSearchListPatientMedicalRecords(int id,String record) {
        List<PatientMedicalRecordDTO> patientMedicalRecordList = new ArrayList<PatientMedicalRecordDTO>();
        for (PatientMedicalRecord patientMedicalRecord : this.patientMedicalRecordDao
                .dbSearchListPatientMedicalRecords(id, record)) {
            PatientMedicalRecordDTO patientMedicalRecordDto = new PatientMedicalRecordDTO(patientMedicalRecord);
            patientMedicalRecordList.add(patientMedicalRecordDto);
        }
        return patientMedicalRecordList;
    }
    
    @Override
    public List<PatientMedicalRecordDTO> doSearchAllListPatientMedicalRecords(String record) {
        List<PatientMedicalRecordDTO> patientMedicalRecordList = new ArrayList<PatientMedicalRecordDTO>();
        for (PatientMedicalRecord patientMedicalRecord : this.patientMedicalRecordDao
                .dbSearchAllListPatientMedicalRecords(record)) {
            PatientMedicalRecordDTO patientMedicalRecordDto = new PatientMedicalRecordDTO(patientMedicalRecord);
            patientMedicalRecordList.add(patientMedicalRecordDto);
        }
        return patientMedicalRecordList;
    }

    @Override
    public PatientMedicalRecordDTO doGetPatientMedicalRecordById(int id) {
        PatientMedicalRecord patientMedicalRecord = this.patientMedicalRecordDao.dbGetPatientMedicalRecordById(id);
        PatientMedicalRecordDTO patientMedicalRecordForm = patientMedicalRecord != null
                ? new PatientMedicalRecordDTO(patientMedicalRecord)
                : null;
        return patientMedicalRecordForm;
    }

    @Override
    public void doUpdatePatientMedicalRecord(PatientMedicalRecordForm patientMedicalRecordForm) {
        PatientMedicalRecord patientMedicalRecord = new PatientMedicalRecord(patientMedicalRecordForm);
        Date a = new Date();
        patientMedicalRecord.setDelFlag(0);
        patientMedicalRecord.setUpdatedAt(a);
        patientMedicalRecordDao.dbUpdatePatientMedicalRecord(patientMedicalRecord);
    }

    @Override
    public void doDeletePatientMedicalRecord(int id) {
        Date a = new Date();
        patientMedicalRecordDao.dbGetPatientMedicalRecordById(id).setDeletedAt(a);
        patientMedicalRecordDao.dbDeletePatientMedicalRecord(id);
    }
}
