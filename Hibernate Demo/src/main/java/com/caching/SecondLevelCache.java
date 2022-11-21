package com.caching;

import com.embedabble.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SecondLevelCache {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session1 = sessionFactory.openSession();
        Student student = session1.get(Student.class, 3);
        System.out.println("Student data: "+student.toString());
        session1.close();

        System.out.println("Session closed");

        //  Session 1 was closed still session 2 didn't fire the query
        //  As the session factory was used as cache
        //  This helps time and space
        Session session2 = sessionFactory.openSession();
        session2.get(Student.class , 3);
        System.out.println("Student data: "+student.toString());
        session2.close();
    }
}
