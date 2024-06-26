package io.aston.hibernatetask.utility;

import io.aston.hibernatetask.entity.Employee;
import io.aston.hibernatetask.entity.EmployeePersonalInfo;
import io.aston.hibernatetask.entity.EmployeeRole;
import io.aston.hibernatetask.entity.Project;
import io.aston.hibernatetask.exception.FailedToReceiveSessionFactory;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

@Slf4j
public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory = null;

    static {
        try {
            sessionFactory = getSessionFactory();
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            throw new FailedToReceiveSessionFactory(e.getMessage());
        }
    }

    private HibernateSessionFactoryUtil() {

    }

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(EmployeeRole.class);
            configuration.addAnnotatedClass(EmployeePersonalInfo.class);
            configuration.addAnnotatedClass(Employee.class);
            configuration.addAnnotatedClass(Project.class);
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
