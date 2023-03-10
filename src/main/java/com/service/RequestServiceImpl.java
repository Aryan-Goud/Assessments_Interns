package com.service;

import com.model.RequestItem;
import com.model.RequestItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Repository
@Service
public class RequestServiceImpl implements RequestService{
    @Autowired
    private SessionFactory sessionFactory;

    public List<RequestItem> getReqname() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<RequestItem> liblist=session.createQuery("from RequestItem",RequestItem.class).list();
        transaction.commit();
        session.close();
        return liblist;
    }

    public RequestItem create(RequestItem name) {
        Session session = sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(name);
        transaction.commit();
        session.close();
        return name;
    }

    public RequestItem getReqId(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        RequestItem requestitem=session.get(RequestItem.class,id);
        transaction.commit();
        session.close();
        return requestitem;
    }

    public RequestItem updateReq(RequestItem name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(name);
        transaction.commit();
        session.close();
        return name;
    }

    public RequestItem deleteReq(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        RequestItem name=session.get(RequestItem.class,id);
        session.delete(name);
        transaction.commit();
        session.close();
        return name;
    }
}
