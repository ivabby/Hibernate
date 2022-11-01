package com.mapping.oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        //  Creating answer
        Answer answer = new Answer(1,"Java is a programming language");

        //  Creating question
        Question question = new Question(1,"What is Java?",answer);
        answer.setQuestion(question);


        //  Creating answer
        Answer answer2 = new Answer(2,"HTML used for web development");

        //  Creating question
        Question question2 = new Question(2,"Why use HTML?",answer2);
        answer2.setQuestion(question2);

        Transaction transaction = session.beginTransaction();
        session.save(question);
        session.save(answer);

        session.save(answer2);
        session.save(question2);
        transaction.commit();

        session.close();
        sessionFactory.close();
    }
}
