//console application

package com.ngm;

import java.util.List;
import java.util.Scanner;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// import com.jakewharton.picnic.Table;
// import com.jakewharton.picnic.TableSection;
// import com.jakewharton.picnic.Row;
// import com.jakewharton.picnic.Cell;
// import com.jakewharton.picnic.CellStyle;
// import com.jakewharton.picnic.TextAlignment;


import com.mitchtalmadge.asciidata.table.ASCIITable;
import com.mitchtalmadge.asciidata.table.formats.UTF8TableFormat;

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
        // DumpClass dc = new DumpClass(String.class);
        // dc.printMethods();

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

        String hql = "FROM Contact WHERE fname like :query"; // Replace 'EntityClass' with the actual class name of your entity

        // Execute the query
        Query<Contact> query = session.createQuery(hql, Contact.class);
        query.setParameter("query", "%");

        List<Contact> records = query.getResultList();

        String[][] contactsArray = new String[records.size()][3];

        int i = 0; // Counter for the outer array

        for (Contact contact : records) {
            // Assign contact details to the array
            contactsArray[i][0] = String.valueOf(contact.getId());
            contactsArray[i][1] = contact.getFname();
            contactsArray[i][2] = contact.getPhone();

            // Increment counter
            i++;
        }

        String[] headers = new String[]{"ID", "Name", "Phone"};

        var table = ASCIITable.fromData(headers, contactsArray).withTableFormat(new UTF8TableFormat()).toString();
        // var table = ASCIITable.fromData(headers, data).toString();

        System.out.println(table);

        // sessionFactory.

        session.beginTransaction();
        session.save(c);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
