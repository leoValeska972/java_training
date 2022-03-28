package ojt.clinic.app.persistence.dao.patientmedicalrecord.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ojt.clinic.app.persistence.dao.patientmedicalrecord.PatientMedicalRecordDao;
import ojt.clinic.app.persistence.entity.PatientMedicalRecord;

@Repository
public class PatientMedicalRecordDaoImpl implements PatientMedicalRecordDao {
    @Autowired
    private SessionFactory sessionFactory;
    private static final String SELECT_PATIENTMEDICALRECORD_HQL = "SELECT p FROM PatientMedicalRecord p WHERE p.delFlag = 0 ";
    private static final String SELECT_PATIENTMEDICALRECORD_BYPID_HQL = "SELECT p FROM PatientMedicalRecord p WHERE p.delFlag = 0 AND p.patientId= :pid";
    private static final String SEARCH_PATIENTMEDICALRECORD_HQL = "SELECT p FROM PatientMedicalRecord p WHERE (p.patientId= :pid AND p.medicalRecord like :record AND p.delFlag = 0) OR (p.patientId= :pid AND p.medicine like :record AND p.delFlag = 0) OR (p.patientId= :pid AND p.cost like :record AND p.delFlag = 0) OR (p.patientId= :pid AND p.remark like :record AND p.delFlag = 0) OR (p.patientId= :pid AND p.recordDateTime like :record AND p.delFlag = 0)";
    private static final String SEARCH_ALL_PATIENTMEDICALRECORD_HQL = "SELECT p FROM PatientMedicalRecord p INNER JOIN p.patientInfo pi WHERE (p.medicalRecord like :record AND p.delFlag = 0) OR (p.medicine like :record AND p.delFlag = 0) OR (p.cost like :record AND p.delFlag = 0) OR (p.remark like :record AND p.delFlag = 0) OR (p.recordDateTime like :record AND p.delFlag = 0) OR (pi.patientName like :record AND p.delFlag = 0)";
    private static final String DELETE_PATIENTMEDICALRECORD_HQL = "UPDATE PatientMedicalRecord p set p.delFlag = 1  where p.patientMedicalRecordId = :pid";

    @Override
    public void dbAddPatientMedicalRecord(PatientMedicalRecord patientMedicalRecord) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(patientMedicalRecord);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PatientMedicalRecord> dbListPatientMedicalRecords() {
        return this.sessionFactory.getCurrentSession().createQuery(SELECT_PATIENTMEDICALRECORD_HQL).list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PatientMedicalRecord> dbListPatientMedicalRecordsByPid(int id) {
        return this.sessionFactory.getCurrentSession().createQuery(SELECT_PATIENTMEDICALRECORD_BYPID_HQL)
                .setParameter("pid", id).list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PatientMedicalRecord> dbSearchListPatientMedicalRecords(int id, String record) {
        return this.sessionFactory.getCurrentSession().createQuery(SEARCH_PATIENTMEDICALRECORD_HQL)
                .setParameter("pid", id).setParameter("record", "%" + record + "%").list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PatientMedicalRecord> dbSearchAllListPatientMedicalRecords(String record) {
        return this.sessionFactory.getCurrentSession().createQuery(SEARCH_ALL_PATIENTMEDICALRECORD_HQL)
                .setParameter("record", "%" + record + "%").list();
    }

    @SuppressWarnings("removal")
    @Override
    public PatientMedicalRecord dbGetPatientMedicalRecordById(int id) {
        Session session = sessionFactory.getCurrentSession();
        PatientMedicalRecord patientMedicalRecord = (PatientMedicalRecord) session.get(PatientMedicalRecord.class,
                new Integer(id));
        return patientMedicalRecord;
    }

    @Override
    public void dbUpdatePatientMedicalRecord(PatientMedicalRecord patientMedicalRecord) {
        Session session = sessionFactory.getCurrentSession();
        session.update(patientMedicalRecord);
    }

    @Override
    public void dbDeletePatientMedicalRecord(int id) {
        sessionFactory.getCurrentSession().createQuery(DELETE_PATIENTMEDICALRECORD_HQL).setParameter("pid", id)
                .executeUpdate();
    }
}
