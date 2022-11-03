package com.lifecycle_state;

import com.embedabble.Certificate;
import com.embedabble.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo {
    public static void main(String[] args) {
        //  Practical of Hibernate Object States
        //  Transient
        //  Persistent
        //  Detached
        //  Removed


        //  Transient State - Object created but
        //  it is neither in DB nor in session
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Student student = new Student(1, "Amit", "Delhi");
        student.setCertificate(new Certificate("Java", "2 months"));

        //  Persistent State - As soon as object is saved
        //  Data is in DB and in state both
        Session session = sessionFactory.openSession();
        session.save(student);

        student.setName("John"); // Here we updated student object
        //  It will save name as john in DB
        //  Session and object are in sync and "John" will be stored in DB

        Transaction transaction = session.beginTransaction();
        transaction.commit(); // Persistent data in Student table stored


        // Detached State
        session.close();
        student.setName("Sachin");
        //  In detach state DB will not be updated as session was closed.
    }
}
