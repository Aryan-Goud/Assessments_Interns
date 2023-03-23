package com.service;

import com.model.RequestItem;
import com.model.RequestItem;
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
public class RequestServiceImpl implements RequestService {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private UserService userService;

    public List<RequestItem> getReqname() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<RequestItem> liblist = session.createQuery("from RequestItem", RequestItem.class).list();
        transaction.commit();
        session.close();
//        transaction.close();
        return liblist;
    }

    public RequestItem create(RequestItem name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        int usersid = search(name.getSysid());
        name.setU_id(usersid);
        session.save(name);
        transaction.commit();
        session.close();
        return name;
    }

    public RequestItem getReqId(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        RequestItem requestitem = session.get(RequestItem.class, id);
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
        RequestItem name = session.get(RequestItem.class, id);
        session.delete(name);
        transaction.commit();
        session.close();
        return name;
    }

    public int search(int sysids) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
//        String query = "select * from usercomplain where sys_id = " +  sysids ;
        List<User> liblist = session.createQuery("from User", User.class).list();

        int userId = -1;
        int f=0;
        for (User user : liblist) {
            if (user.getSystemID() == sysids) {
                f=1;

                userId = user.getS_no();
                break;
            }
        }
        if (f==0){
            userService.create(new User());
            search(sysids);
        }
        transaction.commit();
        session.close();
        return userId;
    }

//    public User creating(User user) {
//        return null;
//    }
//    public User creating(User user) {
//        Session session = sessionFactory.openSession();
//        Transaction transaction=session.beginTransaction();
//        user.setUserEmail("");
//        user.setUserName(RequestItem.class);
//        session.save(user);
//        transaction.commit();
//        session.close();
//        return user;
//    }
}
