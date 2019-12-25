package dao;

import entity.Domain;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

public class DomainDAOHibernate implements DomainDAO {

    private String domain;
    private SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Domain.class)//mappimg işlemi yaptık
            //.addAnnotatedClass()
            .buildSessionFactory();
    private Session session = sessionFactory.getCurrentSession(); //fabrikadan bir tane oturum aldık çünkü sorgu yazcaz

    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Override
    public void domainInsert() {

        try{
            session.beginTransaction(); // sessiona bağlı transection başlattık

           //for(int i = 0 ; i<100000 ; i++ ) { //35-45sn 100bin veri ekledi
                Domain domain = new Domain();
                domain.setBaseUrl(this.domain);
                //domain.setCompleted(i);
                session.save(domain);
            //}
/*
            for(int i = 0 ; i<100000 ; i++ ){ //260sn 100bin veri ekledi
                StoredProcedureQuery department = session.createStoredProcedureQuery("DomainInsert", Domain.class);
                department.registerStoredProcedureParameter("storedProcedeDomainInsert", String.class, ParameterMode.IN);


                this.domain = "www";
                department.setParameter("storedProcedeDomainInsert", this.domain);
                department.execute();
            }*/

            System.out.println("ekledi");
            session.getTransaction().commit();
        }finally{
            //session.close();
            sessionFactory.close();
        }

    }
}
