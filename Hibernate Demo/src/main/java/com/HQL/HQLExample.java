package com.HQL;

import com.embedabble.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HQLExample {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();

        //  HQL
        //  Syntax Query
        // String query = "from Student where city = 'Delhi'";

        //  Dynamic setting city
        // String query = "from Student where city=:x";
        
        //  Using alias for table name
        String query = "from Student as s where s.city=:x";

        Query q = session.createQuery(query);

        //  Dynamic populating city
        q.setParameter("x" , "Delhi");

        //  Single - (Unique) Result []
        //  Multiple - List   Result []
        List<Student> list = q.list();

        for(Student student: list) {
            System.out.println(student.toString());
        }


        factory.close();
    }
}
