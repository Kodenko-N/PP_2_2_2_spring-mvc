package web.config;

import org.hibernate.jpa.HibernatePersistenceProvider;

import javax.persistence.EntityManagerFactory;
import java.util.HashMap;
import java.util.Map;

public class HibernateUtil {

    private static EntityManagerFactory entityManagerFactory;
    static {
        System.out.println("Hibernate Util working");
        try {
            Map<String, String> properties = new HashMap<>();
            properties.put("javax.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver");
            properties.put("javax.persistence.jdbc.url", "jdbc:mysql://localhost:3306/kn_db");
            properties.put("javax.persistence.jdbc.user", "root");
            properties.put("javax.persistence.jdbc.password", "RootPassword1");
            //properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");

            properties.put("hibernate.hbm2ddl.auto", "create");
            properties.put("hibernate.show_sql", "true");
            //properties.put("hibernate.format_sql", "true");
            //properties.put("hibernate.archive.autodetection", "class");
            entityManagerFactory = new HibernatePersistenceProvider().createEntityManagerFactory("User", properties);


            System.out.println("entityManagerFactory created, status = " + entityManagerFactory);
        } catch (Exception e) {
            System.out.println("Hibernate Util exception");
            e.printStackTrace();
        }
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static void shutdown() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}
