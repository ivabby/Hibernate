package com.caching;

import com.embedabble.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FirstLevelCaching {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        //  By default, first level cache is enabled
        Student student = session.get(Student.class, 3);
        System.out.println(student.toString());

        System.out.println("Doing some work");

        // Session wasn't closed and no new query was executed
        //  As the data was already present in session cache
        //  It didn't fire the query again
        student = session.get(Student.class , 3);
        System.out.println(student.toString());

        System.out.println("Object present in cache: "+session.contains(student));

        session.close();
    }
}
