package com.HQL.Cascading;

import com.mapping.oneToMany.Answer;
import com.mapping.oneToMany.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class CascadingExample {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Question question = new Question();
        question.setQuestionId(10);
        question.setQuestion("What is Cascading?");

        Answer answer = new Answer();
        answer.setAnswerId(100);
        answer.setAnswer("In Hibernate it is an important concept");


        Answer answer2 = new Answer();
        answer2.setAnswerId(101);
        answer2.setAnswer("Second answer");

        question.setAnswer(Arrays.asList(answer,answer2));

        Transaction transaction = session.beginTransaction();

        //  If we only save question and not answer
        //  Question will be saved but automatically it will not save the answer
        session.save(question);

        transaction.commit();

        session.close();
        sessionFactory.close();
    }
}
