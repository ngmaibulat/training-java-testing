package com.ngm;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import io.github.cdimascio.dotenv.Dotenv;

public class HibernateConfig {

    private static Dotenv dotenv = Dotenv.load();

    private static String getVariable(String name) {
        // Check for system environment variable first
        String value = System.getenv(name);

        // If not found, look for variable in dotenv
        if (value == null || value.isEmpty()) {
            value = dotenv.get(name);
        }

        return value;
    }

    public static SessionFactory buildSessionFactory() {
        // Dotenv dotenv = Dotenv.load();
        Configuration configuration = new Configuration();

        // Database connection properties
        configuration.setProperty("hibernate.connection.driver_class", getVariable("DB_DRIVER"));
        configuration.setProperty("hibernate.connection.url", getVariable("DB_URL"));
        configuration.setProperty("hibernate.connection.username", getVariable("DB_USERNAME"));
        configuration.setProperty("hibernate.connection.password", getVariable("DB_PASSWORD"));

        // Other Hibernate properties
        configuration.setProperty("hibernate.dialect", getVariable("DB_DIALECT"));
        // configuration.setProperty("hibernate.show_sql", "true");


        // configuration.setProperty("hibernate.connection.driver_class", "org.sqlite.JDBC");
        // configuration.setProperty("hibernate.connection.url", "jdbc:sqlite:database.db");
        // configuration.setProperty("hibernate.connection.username", ""); // SQLite does not require a username
        // configuration.setProperty("hibernate.connection.password", ""); // SQLite does not require a password

        // // Other Hibernate properties
        // configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLiteDialect");
        // configuration.setProperty("hibernate.show_sql", "true");


        // Add your entity classes to the configuration
        // configuration.addAnnotatedClass(com.ngm.Contact.class);
        configuration.addAnnotatedClass(Contact.class);

        // Properties props = configuration.getProperties();
        // props.forEach((key, value) -> System.out.println(key + ": " + value));

        // // Print annotated classes
        // Map<String, ClassMetadata> entities = configuration.getClassMappings();
        // for (String entityName : entities.keySet()) {
        //     System.out.println("Entity name: " + entityName);
        // }

        return configuration.buildSessionFactory();
    }
}
