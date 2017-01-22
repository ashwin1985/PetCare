package com.petcare.db.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory = null;
    private static String resource = null;

    public static void buildSessionFactory() {
        buildSessionFactory(null);
    }

    public static void buildSessionFactory(String connectionUrl) {
        try {
            Configuration config = resource == null ? new Configuration().configure()
                    : new Configuration().configure(resource);

            if(connectionUrl != null && !connectionUrl.isEmpty()) {
                config.setProperty("hibernate.connection.url", connectionUrl);
            }

            sessionFactory = config.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            throw new DBException("No Session Factory");
        }

        return sessionFactory;
    }

    public static void shutdown() {
        if(sessionFactory != null) {
            sessionFactory.close();
        }
    }

    public static String getResource() { return resource; }

    public static void setResource(String resource) { HibernateUtil.resource = resource; }
}
