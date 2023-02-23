package com.services;

import com.model.Patient;
import com.model.Visit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitServiceImpl implements VisitService{
    @Autowired
    private SessionFactory sessionFactory;
    public List<Visit> getVisits() {
        Session session= sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        List<Visit> visitlist=session.createQuery("from Visit",Visit.class).list();
        transaction.commit();
        session.close();
        return visitlist;
    }

    public Visit getVisitId(int vId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Visit visit=session.get(Visit.class,vId);
        transaction.commit();
        session.close();
        return visit;
    }

    public Visit create(Visit name) {
        Session session = sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(name);
        transaction.commit();
        session.close();
        return name;
    }

    public Visit updateVisit(Visit visit) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(visit);
        transaction.commit();
        session.close();
        return visit;
    }

    public Visit deleteVisit(int vId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Visit visit=session.get(Visit.class,vId);
        session.delete(visit);
        transaction.commit();
        session.close();
        return visit;
    }

}
