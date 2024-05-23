package io.aston.hibernatetask.utility;

import io.aston.hibernatetask.entity.EmployeeRole;
import io.aston.hibernatetask.exception.FailedToReceiveSessionFactory;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

@Slf4j
@NoArgsConstructor
public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory = null;

    static {
        try {
            sessionFactory = getSessionFactory();
        } catch (RuntimeException e) {
            throw new FailedToReceiveSessionFactory(e.getMessage());
        }
    }

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(EmployeeRole.class);
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());
            return sessionFactory;
        }
        return sessionFactory;
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }
}
