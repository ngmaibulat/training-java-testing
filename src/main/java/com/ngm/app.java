//console application

package com.ngm;

import java.util.Scanner;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

public class app {
    public static void main(String[] args) {
        // Scanner input = new Scanner(System.in);
        // System.out.println("Enter a number: ");
        // int num = input.nextInt();
        // System.out.println("You entered " + num);
        // input.close();

        SessionFactory sessionFactory = HibernateConfig.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Contact c = new Contact("David", "Linch", "+9 999 999 99 99");

        // sessionFactory.

        session.beginTransaction();
        session.save(c);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
