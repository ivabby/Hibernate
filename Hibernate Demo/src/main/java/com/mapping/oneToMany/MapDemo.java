package com.mapping.oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class MapDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        //  Creating answer
        Answer answer = new Answer(1,"Java is a programming language");
        Answer answer2 = new Answer(2 , "Java is an island");

        // Creating question
        Question question = new Question(1, "What is Java?", Arrays.asList(answer , answer2));
        answer.setQuestion(question);
        answer2.setQuestion(question);

        Transaction transaction = session.beginTransaction();
        session.save(question);
        session.save(answer);
        session.save(answer2);

        transaction.commit();

        //  Fetch Data
        question = session.load(Question.class , 1);
        System.out.println(question.getQuestionId()+" "+ question.getQuestion());

        answer = session.load(Answer.class , 1);
        System.out.println(answer.toString()+" "+answer.getQuestion());

        session.close();
        sessionFactory.close();
    }
}
