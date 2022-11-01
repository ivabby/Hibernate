package com.mapping.manyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Arrays;

public class MappingDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        Employee employee1 = new Employee(1, "David");
        Employee employee2 = new Employee(2, "Ben");

        Project project1 = new Project(1 , "Library Management");
        Project project2 = new Project(2 , "Telecom Domain");

        employee1.setProjectList(Arrays.asList(project1,project2));
        employee2.setProjectList(Arrays.asList(project1));

        project1.setEmployeeList(Arrays.asList(employee1,employee2));
        project2.setEmployeeList(Arrays.asList(employee1));

        session.save(employee1);
        session.save(employee2);
        session.save(project1);
        session.save(project2);

        transaction.commit();

        session.close();
        factory.close();
    }
}
