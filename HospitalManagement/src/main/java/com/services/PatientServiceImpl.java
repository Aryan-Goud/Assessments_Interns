package com.services;

import com.model.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Patient> getPName() {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        List<Patient>patientList=session.createQuery("from Patient",Patient.class).list();
        transaction.commit();
        session.close();
        return patientList;
    }

    public Patient getPId(int pId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Patient patient=session.get(Patient.class,pId);
        transaction.commit();
        session.close();
        return patient;
    }

    public Patient create(Patient name) {
        Session session = sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(name);
        transaction.commit();
        session.close();
        return name;
    }

    public Patient updatePatient(Patient name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(name);
        transaction.commit();
        session.close();
        return null;
    }

    public Patient deletePatient(int pId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Patient patient=session.get(Patient.class,pId);
        session.delete(patient);
        transaction.commit();
        session.close();
        return patient;
    }
}
