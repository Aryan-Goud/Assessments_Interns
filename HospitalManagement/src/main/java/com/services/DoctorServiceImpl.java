package com.services;

import com.model.Doctor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    private SessionFactory sessionFactory;

    public List<Doctor> getDocName() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Doctor> doctorslist=session.createQuery("from Doctor",Doctor.class).list();
        transaction.commit();
        session.close();
        return doctorslist;
    }

    public Doctor getDocId(int docId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Doctor docIds=session.get(Doctor.class,docId);
        transaction.commit();
        session.close();
        return docIds;
    }

    public Doctor create(Doctor name) {
        Session session = sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(name);
        transaction.commit();
        session.close();
        return name;
    }

    public Doctor updateDoctor(Doctor name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(name);
        transaction.commit();
        session.close();
        return name;
    }

    public Doctor deleteDoctor(int docId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Doctor docIds=session.get(Doctor.class,docId);
        session.delete(docIds);
        transaction.commit();
        session.close();
        return docIds;
    }
}
