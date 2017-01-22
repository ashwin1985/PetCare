package com.petcare.db.transaction;

import org.hibernate.Session;

@FunctionalInterface
public interface WorkUnit<T> {

    T doWork(Session session) throws Exception;

}
