package Test;

import com.sun.webkit.WebPage;
import dao.DomainDAO;
import dao.DomainDAOHibernate;
import entity.Domain;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class main {
    public static void main(String[] args){

        long beginTime = 0, endTime = 0;
        beginTime = System.currentTimeMillis();

        //getSession();
        DomainDAOHibernate domainDAOHibernate = new DomainDAOHibernate();
        domainDAOHibernate.setDomain("www");
        domainDAOHibernate.domainInsert();


        /*for(int i = 0 ; i<10000 ; i++ ){

            Domain domain = new Domain();
            domain.setBaseUrl("www");
            domain.setCompleted(0);
            DomainDAOHibernate domainDAOHibernate = new DomainDAOHibernate();//DomainController domainController = new DomainController(domain);
            domainDAOHibernate.domainInsert(domain);
        }
*/
        endTime = System.currentTimeMillis();
        System.out.println("Runtime: " + ((double) (endTime - beginTime)) / 1000);
    }

    public static void getSession(){
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Domain.class)//mappimg işlemi yaptık
                //.addAnnotatedClass()
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();// sessiona bağlı transection başlattık
            Domain domain = new Domain();
            domain.setBaseUrl("getlink2 new");

            //session.merge(domain);
            session.save(domain); //insert

            session.getTransaction().commit();
        }finally{
            sessionFactory.close();
        }
        System.out.println("geldi ");
    }
}
