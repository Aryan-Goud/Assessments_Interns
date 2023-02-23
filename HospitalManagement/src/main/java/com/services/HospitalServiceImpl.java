package com.services;

import com.model.Doctor;
import com.model.Hospital;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Hospital> getHospName() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Hospital> hospitallist=session.createQuery("from Hospital",Hospital.class).list();
        transaction.commit();
        session.close();
        return hospitallist;
    }

    public Hospital getHospId(int hosId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Hospital hospital=session.get(Hospital.class,hosId);
        transaction.commit();
        session.close();
        return hospital;
    }

    public Hospital create(Hospital name) {
        Session session = sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(name);
        transaction.commit();
        session.close();
        return name;
    }

    public Hospital updateHospital(Hospital name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(name);
        transaction.commit();
        session.close();
        return name;
    }

    public Hospital deleteHospital(int hosId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Hospital hospital=session.get(Hospital.class,hosId);
        session.delete(hospital);
        transaction.commit();
        session.close();
        return hospital;
    }
}
