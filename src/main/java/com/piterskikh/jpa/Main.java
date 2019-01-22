package com.piterskikh.jpa;


import com.piterskikh.jpa.entity.Post;
import com.piterskikh.jpa.entity.PostComment;
import com.piterskikh.jpa.testconnection.TransactionManagerSetup;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.UserTransaction;


public class Main {

    public static void main(String[] args) throws Exception {

        TransactionManagerSetup TM = new TransactionManagerSetup();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HelloWorldPU");


        EntityManager em = emf.createEntityManager();
        UserTransaction tx = TM.getUserTransaction();
       tx.begin();


        Post post = new Post("First post");

        post.getComments().add(
                new PostComment("My first review")
        );
        post.getComments().add(
                new PostComment("My second review")
        );
        post.getComments().add(
                new PostComment("My third review")
        );

        em.persist(post);



        tx.commit();







          /*  List<Message> messages = em.createQuery("select m from Message m", Message.class).getResultList();

            for (Message message3 : messages) {

                System.out.println(message3.getText());

            }*/



    }
}
