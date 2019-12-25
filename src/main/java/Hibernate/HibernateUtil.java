package Hibernate;

import entity.Domain;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sun.misc.ExtensionInstallationException;

public class HibernateUtil {

    private static final SessionFactory factory = buildSessionFactory();

    public static SessionFactory buildSessionFactory(){
        try{
            Configuration cfg = new Configuration();
            //map işlemi yaptık 2 farklı şekilde yapılabilir. biz bu şekilde yaptık diğer .xml içinde yapılır
            cfg.addAnnotatedClass(Domain.class);
            SessionFactory sessionFactory = cfg.configure("hibernate.cfg.xml").buildSessionFactory();

            return sessionFactory;

        }catch (Exception e){

            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getFactory() {
        return factory;
    }
}
