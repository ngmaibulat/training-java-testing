package com.ngm;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {
    public static SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration();

        // // Database connection properties
        // configuration.setProperty("hibernate.connection.driver_class", System.getenv("DB_DRIVER"));
        // configuration.setProperty("hibernate.connection.url", System.getenv("DB_URL"));
        // configuration.setProperty("hibernate.connection.username", System.getenv("DB_USERNAME"));
        // configuration.setProperty("hibernate.connection.password", System.getenv("DB_PASSWORD"));

        // // Other Hibernate properties
        // configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        // configuration.setProperty("hibernate.show_sql", "true");


        configuration.setProperty("hibernate.connection.driver_class", "org.sqlite.JDBC");
        configuration.setProperty("hibernate.connection.url", "jdbc:sqlite:database.db");
        configuration.setProperty("hibernate.connection.username", ""); // SQLite does not require a username
        configuration.setProperty("hibernate.connection.password", ""); // SQLite does not require a password

        // Other Hibernate properties
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLiteDialect");
        configuration.setProperty("hibernate.show_sql", "true");


        // Add your entity classes to the configuration
        configuration.addAnnotatedClass(Contact.class);

        return configuration.buildSessionFactory();
    }
}
