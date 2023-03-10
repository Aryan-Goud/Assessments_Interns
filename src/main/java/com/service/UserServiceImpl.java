package com.service;

import com.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private SessionFactory sessionFactory;
//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public UserServiceImpl(DataSource dataSource) {
//        this.jdbcTemplate=new JdbcTemplate(dataSource);
//    }
//
//    public void insert(User user) {
//        String sql = "INSERT INTO usercomplain (user_id, user_name, user_email,user_phno,sys_id,ops,issue) VALUES (?, ?, ?,?,?,?,?)";
//        jdbcTemplate.update(sql, user.getS_no(), user.getUserName(), user.getUserEmail(),user.getUserPh(),user.getSystemID(),user.getOps(),user.getIssues());
//
//    }

    public List<User> getusername() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<User> liblist=session.createQuery("from User",User.class).list();
        transaction.commit();
        session.close();
        return liblist;
    }



    public User create(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
        return user;
    }

//    public User check(User exists) {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        List<User> liblist=session.createQuery("from User",User.class).list();
//        User uc=new User();
//        int sys= Integer.parseInt(uc.getSystemID());
//        for (User i:liblist
//             ) {
//            int s1= Integer.parseInt(uc.getSystemID());
//            s1.
//        }
//        }
//        return null;
//    }

    public User getUserId(int systemid) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user=session.get(User.class,systemid);

        transaction.commit();
        session.close();
        return user;
    }

    public User updateUser(User name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(name);
        transaction.commit();
        session.close();
        return name;
    }

    public User deleteUser(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User name=session.get(User.class,id);
        session.delete(name);
        transaction.commit();
        session.close();
        return name;
    }
}
