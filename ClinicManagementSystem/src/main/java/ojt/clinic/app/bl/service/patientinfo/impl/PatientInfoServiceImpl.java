package ojt.clinic.app.bl.service.patientinfo.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ojt.clinic.app.bl.dto.PatientInfoDTO;
import ojt.clinic.app.bl.service.patientinfo.PatientInfoService;
import ojt.clinic.app.persistence.dao.patientinfo.PatientInfoDao;
import ojt.clinic.app.persistence.entity.PatientInfo;
import ojt.clinic.app.web.form.PatientInfoForm;

@Service
@Transactional
public class PatientInfoServiceImpl implements PatientInfoService {

    @Autowired
    private PatientInfoDao patientInfoDao;

    @Override
    public void doAddPatientInfo(PatientInfoForm patientInfoForm) {
        PatientInfo patientInfo = new PatientInfo(patientInfoForm);
        Date a = new Date();
        patientInfo.setDelFlag(0);
        patientInfo.setUpdatedAt(a);
        patientInfo.setToday(LocalDate.now());
        patientInfoDao.dbAddPatientInfo(patientInfo);
    }

    @Override
    public void doAddTodayPatient(LocalDate today, int id) {
        patientInfoDao.dbAddTodayPatient(today, id);
    }

    @Override
    public List<PatientInfoDTO> doListPatientInfos() {
        List<PatientInfoDTO> patientInfoList = new ArrayList<PatientInfoDTO>();
        for (PatientInfo patientInfo : this.patientInfoDao.dbListPatientInfos()) {
            PatientInfoDTO patientInfoDto = new PatientInfoDTO(patientInfo);
            patientInfoList.add(patientInfoDto);
        }
        return patientInfoList;
    }

    @Override
    public List<PatientInfoDTO> doSearchListPatientInfos(String search) {
        List<PatientInfoDTO> patientInfoList = new ArrayList<PatientInfoDTO>();
        for (PatientInfo patientInfo : this.patientInfoDao.dbSearchListPatientInfos(search)) {
            PatientInfoDTO patientInfoDto = new PatientInfoDTO(patientInfo);
            patientInfoList.add(patientInfoDto);
        }
        return patientInfoList;
    }

    @Override
    public List<PatientInfoDTO> doTodayPatients(LocalDate today, String status) {
        List<PatientInfoDTO> patientInfoList = new ArrayList<PatientInfoDTO>();
        for (PatientInfo patientInfo : this.patientInfoDao.dbTodayPatients(today, status)) {
            PatientInfoDTO patientInfoDto = new PatientInfoDTO(patientInfo);
            patientInfoList.add(patientInfoDto);
        }
        return patientInfoList;
    }

    @Override
    public PatientInfoDTO doGetPatientInfoById(int id) {
        PatientInfo patientInfo = this.patientInfoDao.dbGetPatientInfoById(id);
        PatientInfoDTO patientInfoForm = patientInfo != null ? new PatientInfoDTO(patientInfo) : null;
        return patientInfoForm;
    }

    @Override
    public void doUpdatePatientInfo(PatientInfoForm patientInfoForm) {
        PatientInfo patientInfo = new PatientInfo(patientInfoForm);
        Date a = new Date();
        patientInfo.setDelFlag(0);
        patientInfo.setUpdatedAt(a);
        patientInfoDao.dbUpdatePatientInfo(patientInfo);
    }

    @Override
    public void doChangeStatus(int id) {
        patientInfoDao.dbChangeStatus(id);
    }

    @Override
    public void doDeletePatientInfo(int id) {
        Date a = new Date();
        patientInfoDao.dbGetPatientInfoById(id).setDeletedAt(a);
        patientInfoDao.dbDeletePatientInfo(id);
    }
}
