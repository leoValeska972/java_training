package ojt.clinic.app.persistence.dao.patientinfo.impl;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ojt.clinic.app.persistence.dao.patientinfo.PatientInfoDao;
import ojt.clinic.app.persistence.entity.PatientInfo;

@Repository
public class PatientInfoDaoImpl implements PatientInfoDao {
    @Autowired
    private SessionFactory sessionFactory;
    private static final String SELECT_PATIENTINFO_HQL = "SELECT p FROM PatientInfo p WHERE p.delFlag = 0 ";
    private static final String SEARCH_PATIENTINFO_HQL = "SELECT p FROM PatientInfo p WHERE (p.patientName like :search AND p.delFlag = 0) OR (p.patientAge = :search AND p.delFlag = 0) OR (p.patientGender like :search AND p.delFlag = 0) OR (p.patientAddress like :search AND p.delFlag = 0) OR (p.patientPhone like :search AND p.delFlag = 0)";
    private static final String DELETE_PATIENTINFO_HQL = "UPDATE PatientInfo p SET p.delFlag = 1  where p.patientId = :pid";
    private static final String SELECT_TODAY_PATIENT_HQL = "SELECT p FROM PatientInfo p WHERE p.delFlag = 0 AND p.today = :today AND p.status = :status";
    private static final String UPDATE_TODAY_PATIENT_HQL = "UPDATE PatientInfo p SET p.today = :today WHERE p.delFlag = 0 AND p.patientId = :pid";
    private static final String UPDATE_PATIENT_STATUS_HQL = "UPDATE PatientInfo p SET p.status = 'Finished' WHERE p.delFlag = 0 AND p.patientId = :pid";

    @Override
    public void dbAddPatientInfo(PatientInfo patientInfo) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(patientInfo);
    }

    @Override
    public void dbAddTodayPatient(LocalDate today, int id) {
        sessionFactory.getCurrentSession().createQuery(UPDATE_TODAY_PATIENT_HQL).setParameter("today", today)
                .setParameter("pid", id).executeUpdate();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PatientInfo> dbListPatientInfos() {
        return this.sessionFactory.getCurrentSession().createQuery(SELECT_PATIENTINFO_HQL).list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PatientInfo> dbSearchListPatientInfos(String search) {
        return this.sessionFactory.getCurrentSession().createQuery(SEARCH_PATIENTINFO_HQL)
                .setParameter("search", "%" + search + "%").list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PatientInfo> dbTodayPatients(LocalDate today,String status) {
        return this.sessionFactory.getCurrentSession().createQuery(SELECT_TODAY_PATIENT_HQL)
                .setParameter("today", today).setParameter("status", status).list();
    }

    @SuppressWarnings("removal")
    @Override
    public PatientInfo dbGetPatientInfoById(int id) {
        Session session = sessionFactory.getCurrentSession();
        PatientInfo patientInfo = (PatientInfo) session.get(PatientInfo.class, new Integer(id));
        return patientInfo;
    }

    @Override
    public void dbUpdatePatientInfo(PatientInfo patientInfo) {
        Session session = sessionFactory.getCurrentSession();
        session.update(patientInfo);
    }

    @Override
    public void dbChangeStatus(int id) {
        sessionFactory.getCurrentSession().createQuery(UPDATE_PATIENT_STATUS_HQL).setParameter("pid", id).executeUpdate();
    }

    @Override
    public void dbDeletePatientInfo(int id) {
        sessionFactory.getCurrentSession().createQuery(DELETE_PATIENTINFO_HQL).setParameter("pid", id).executeUpdate();
    }
}