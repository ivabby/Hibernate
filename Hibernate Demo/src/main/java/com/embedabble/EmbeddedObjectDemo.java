package com.embedabble;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbeddedObjectDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Student student = new Student(2, "Miller", "Arizona");
        Certificate certificate = new Certificate("Android", "2 months");
        student.setCertificate(certificate);

        Student student2 = new Student(3, "Warner", "Sydeny");
        Certificate certificate2 = new Certificate("Web Developer", "1 month");
        student2.setCertificate(certificate2);

        Transaction transaction = session.beginTransaction();

        session.save(student);
        session.save(student2);

        transaction.commit();


        session.close();
        sessionFactory.close();
    }
}
