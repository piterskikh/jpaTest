package com.piterskikh.jpa;


import com.piterskikh.jpa.entity.Address;
import com.piterskikh.jpa.entity.Item;
import com.piterskikh.jpa.entity.Message;
import com.piterskikh.jpa.entity.User;
import com.piterskikh.jpa.testconnection.TransactionManagerSetup;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.UserTransaction;
import java.util.List;


public class Main {

    public static void main(String[] args) throws Exception {

        TransactionManagerSetup TM = new TransactionManagerSetup();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HelloWorldPU");


        EntityManager em = emf.createEntityManager();
        UserTransaction tx = TM.getUserTransaction();
        tx.begin();

       Message message = new Message();
        message.setText("Hello World!");

        Message message1 = new Message();
        message1.setText("Hello World 1!");

        Item message2 = new Item();
        message2.setText("Hello World 22!");
        //message2.setText("");

        User user = new User();
       // user.setHomeAddress(new Address("One", "Two", "Three"));


        em.persist(message);
        em.persist(message1);
        em.persist(message2);
        em.persist(user);





        tx.commit();







            List<Message> messages = em.createQuery("select m from Message m", Message.class).getResultList();

            for (Message message3 : messages) {

                System.out.println(message3.getText());

            }



    }
}
