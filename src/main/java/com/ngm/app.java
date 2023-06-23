//console application

package com.ngm;

import java.util.List;
import java.util.Scanner;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class app {

    public static SessionFactory sessionFactory;
    public static Session session;
    private static final Logger logger = LoggerFactory.getLogger(app.class);

    public static Session getSession() {
        try {
            sessionFactory = HibernateConfig.buildSessionFactory();
            session = sessionFactory.openSession();
            return session;
        }
        catch (IllegalStateException e) {
            logger.error("Connection error. Please check env variables");
            // System.out.println("Connection error. Please check env variables");
            // exit the program
            System.exit(0);
        }
        catch (org.hibernate.service.spi.ServiceException e) {
            logger.error("Connection error. Please check env variables");
            // System.out.println("Connection error. Please check env variables");
            // exit the program
            System.exit(0);
        }
        catch (Throwable t) {
            logger.error("Unknown Error.");
            // System.out.println(t.getMessage());
            System.out.println("Class:" + t.getClass().getName());
            // exit the program
            System.exit(0);
        }
        return null;
    }

    public static void main(String[] args) {
        // Scanner input = new Scanner(System.in);
        // System.out.println("Enter a number: ");
        // int num = input.nextInt();
        // System.out.println("You entered " + num);
        // input.close();

        // logger.info("This is an informational message");
        // logger.debug("This is a debug message");
        // logger.warn("This is a warning message");
        // logger.error("This is an error message");

        // SessionFactory sessionFactory;
        Session session = getSession();

        // Contact c = new Contact("David", "Linch", "+9 999 999 99 99");
        
        Long id = 9L; // Replace with the actual ID of the entity you want to retrieve

        Contact c = session.get(Contact.class, id);

        c.setFname("John");
        c.setLname("Doe");

        String hql = "FROM Contact"; // Replace 'EntityClass' with the actual class name of your entity

        // Execute the query
        Query<Contact> query = session.createQuery(hql, Contact.class);
        List<Contact> records = query.getResultList();

        for (Contact contact : records) {
            System.out.println("Contact ID: " + contact.getId());
            System.out.println("Name: " + contact.getFname());
            // System.out.println("Email: " + contact.getEmail());
            System.out.println("Phone: " + contact.getPhone());
            System.out.println("-------------------------");
        }


        // sessionFactory.

        session.beginTransaction();
        session.save(c);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
