package com.gist.dao;


import com.gist.handler.HibernateTransactionHandler;
import com.gist.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    private HibernateTransactionHandler hibernateTransactionHandler = new HibernateTransactionHandler();

    @Override
    public User save(User user) {
        return (User) hibernateTransactionHandler.performDBOperationWithRollbackOnError(sessionFactory.getCurrentSession(), () -> {
            sessionFactory.getCurrentSession().save(user);
            return user;
        });
    }

    @Override
    public List list() {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from User");
        return query.getResultList();
    }

    @Override
    public List get(Long id) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from User WHERE id = " + id);
        return query.getResultList();
    }

    @Override
    public Long delete(Long id) {
        Transaction transaction = sessionFactory.getCurrentSession().getTransaction();
        try {
            User user = sessionFactory.getCurrentSession().get(User.class, id);
            if (user != null) {
                sessionFactory.getCurrentSession().remove(user);
                return id;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            throw e;
        }
    }

    @Override
    public User update(Long id, User user) {
        return (User) hibernateTransactionHandler.performDBOperationWithRollbackOnError(sessionFactory.getCurrentSession(), () -> {
            User dbValue = sessionFactory.getCurrentSession().get(User.class, id);
            if (dbValue != null) {
                dbValue.setUsername(user.getUsername() != null ? user.getUsername() : dbValue.getUsername());
                dbValue.setMobile(user.getMobile() != null ? user.getMobile() : dbValue.getMobile());
                dbValue.setLocation(user.getLocation() != null ? user.getLocation() : dbValue.getLocation());
                sessionFactory.getCurrentSession().flush();
                return dbValue;
            }

            return null;
        });
    }

}
