package com.HQL.pagination;

import com.embedabble.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HQLPagination {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();


        Query query = session.createQuery("from Student" , Student.class);

        //  Implementing pagination using Hibernate
        query.setFirstResult(1); // Starting Index
        query.setMaxResults(2); // How many results to fetch

        List<Student> studentList = query.list();
        for(Student student: studentList) {
            System.out.println(student.toString());
        }


        session.close();
        sessionFactory.close();
    }
}
