package com.HQL.NativeQuery;

import com.embedabble.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class SQLExample {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Query query = session.createSQLQuery("select * from Student");

        List<Object[]> students = query.list();
        for(Object[] student: students) {
            System.out.println(Arrays.toString(student));
        }

        session.close();
        sessionFactory.close();
    }
}
