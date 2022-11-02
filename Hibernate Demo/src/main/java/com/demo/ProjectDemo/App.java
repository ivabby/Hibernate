package com.demo.ProjectDemo;

import com.embedabble.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("Project Started!!!!");

        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        System.out.println("Creating student");
        Student student = new Student(1, "David", "New York");

        System.out.println("Student details :" + student.toString());

        // Reading Image
        FileInputStream fis = new FileInputStream("src/main/resources/image.jpeg");
        byte data[] = new byte[fis.available()];
        fis.read(data);

        // Creating Address object

        Address address = new Address("Street1" , "Delhi" , false , 10.0 , new Date(),data);

        // Get current session
        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        //  Saving the student object in DB
        session.save(student);
        session.save(address);

        // Committing the transaction to see changes in DB
        // session.getTransaction().commit();
        transaction.commit();

        // Closing the session
        session.close();

        // Closing session factory
        factory.close();

        System.out.println("Done");
    }
}
