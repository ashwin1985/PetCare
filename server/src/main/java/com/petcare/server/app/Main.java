package com.petcare.server.app;

import com.petcare.db.util.HibernateUtil;

public class Main {

    public static void main(String args[]) throws Exception {
        HibernateUtil.buildSessionFactory();
        new BaseServer().start();
    }
}
