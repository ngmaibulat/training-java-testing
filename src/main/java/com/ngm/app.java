//console application

package com.ngm;

import java.util.Scanner;
import org.hibernate.SessionFactory;

public class app {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = input.nextInt();
        System.out.println("You entered " + num);
        input.close();

        SessionFactory sessionFactory = HibernateConfig.buildSessionFactory();
    }
}
