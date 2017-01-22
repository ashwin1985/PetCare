package com.petcare.db.transaction;

import com.petcare.db.util.DBException;
import com.petcare.db.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TransactionTemplate {

    private static final Logger logger = LoggerFactory.getLogger(TransactionTemplate.class);

    public TransactionTemplate() {}

    private <T> T execute(WorkUnit<T> workUnit) throws DBException {
        Transaction tx = null;
        Session session;
        T entity;

        try {
            session = getSession();
            tx = session.beginTransaction();

            entity = workUnit.doWork(session);

            tx.commit();
        } catch(Throwable e) {
            logger.error(e.toString(), e);
            if(tx != null)  tx.rollback();
            throw new DBException(e);
        }

        return entity;
    }

    protected Session getSession() {
            return HibernateUtil.getSessionFactory().getCurrentSession();
    }
}
