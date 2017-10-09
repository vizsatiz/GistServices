package com.gist.handler;

import com.gist.constants.DBOperation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kh1888 on 08/10/17.
 */
public class HibernateTransactionHandler {

    public Object performDBOperationWithRollbackOnError(Session session, DBOperation dbOperation) {
        Transaction transaction = session.getTransaction();
        try {
            return dbOperation.perform();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            throw e;
        }
    }

}
