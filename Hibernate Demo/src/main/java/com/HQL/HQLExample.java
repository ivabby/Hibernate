package com.HQL;

import com.embedabble.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
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

        System.out.println("Select query result:");
        for(Student student: list) {
            System.out.println(student.toString());
        }

        System.out.println("---------------------");
        System.out.println();

        Transaction transaction = session.beginTransaction();

        /*
        //  Delete student who are from Kanpur
        System.out.println("Delete Query:");

        q = session.createQuery("delete from Student as s where s.city=:x");
        q.setParameter("x" , "Kanpur");
        System.out.println("Deleted: "+q.executeUpdate()); // Execute the delete query
        */


        //  Update Student query
        System.out.println("Update Query:");
        q = session.createQuery("update from Student as s set s.city=:x where s.city=:y");
        q.setParameter("x" , "Lucknow");
        q.setParameter("y" , "Kanpur");

        System.out.println("Update: "+q.executeUpdate());


        System.out.println("------------------------");



        //  Join Query
        q = session.createQuery("select q.question,q.questionId,a.answer from " +
                "Question as q " +
                "INNER JOIN " +
                "q.answer as a");

        List<Object[]> list2 = q.getResultList();

        for(Object[] object: list2) {
            System.out.println(Arrays.toString(object));
        }







        transaction.commit();


        factory.close();
    }
}
