package com.demo.ProjectDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
    public static void main(String[] args) {
        //  GET VS LOAD
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();


        //  Get student with id - 1
        Student student = (Student) session.get(Student.class, 1);
        System.out.println(student.toString());

        //  Get student with id - 200
//        student = session.get(Student.class , 200);  // Returns student as null
//        System.out.println(student);

        Address address = session.get(Address.class, 1);
        System.out.println(address.getCity() + " " + address.getStreet());

        //  Load student with id - 1
        student = session.load(Student.class, 1);
        // Lazy initialization
        //  Load object only when required not when the line was encountered
        // System.out.println(student.toString());

        //  Object not Found exception if we use load and data not present in DB
        // address = session.load(Address.class , 200);
        // System.out.println(address);

        session.close();
        factory.close();
    }
}
