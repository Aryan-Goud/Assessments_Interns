package com.service;

import com.model.Status;
import com.model.Status;
import com.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Repository
@Service
public class StatusServiceImpl implements StatusService{
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private RequestServiceImpl requestService;
    public List<Status> getStatus() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Status> liblist=session.createQuery("from Status",Status.class).list();
        transaction.commit();
        session.close();
//        transaction.close();
        return liblist;
    }

    public Status create(Status name) {
        Session session = sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        int usersid = search(name.getSysId());
        name.setuId(usersid);
        session.save(name);
        transaction.commit();
        session.close();
        return name;
    }

    public Status getStatusId(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Status statusitem=session.get(Status.class,id);
        transaction.commit();
        session.close();
        return statusitem;
    }

    public Status updateStatus(Status name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        int usersid = search(name.getSysId());
        name.setuId(usersid);
//        Status status1 = new Status();
        Status st=pri(name);
        session.saveOrUpdate(st);
        transaction.commit();
        session.close();
        return name;
    }

    public Status deleteStatus(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Status name=session.get(Status.class,id);
        session.delete(name);
        transaction.commit();
        session.close();
        return name;
    }

    public int search(int sysids) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<User> liblist=session.createQuery("from User",User.class).list();
        int userId = -1;
//        int f=0;
        for(User user : liblist) {
            if(user.getSystemID()==sysids) {
//                f=1;

                userId = user.getS_no();
                break;
            }
        }
        transaction.commit();
        session.close();
        return userId;

    }

    public Status pri(Status name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Status> liblist = session.createQuery("from Status", Status.class).list();
        for (Status status : liblist
        ) {
            if (name.getSysId() == status.getSysId()) {
                name.setStatId(status.getStatId());
                break;
            }
        }
        transaction.commit();
        session.close();
        return name;
    }
}
