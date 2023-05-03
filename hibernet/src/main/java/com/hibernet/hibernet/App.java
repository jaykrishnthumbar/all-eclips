package com.hibernet.hibernet;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Started.." );
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        User us=new User();
        
        us.setId(1);
        us.setName("Jacky");
        us.setPassword("jack");
        
        System.out.println(us);
        
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(us);
        tx.commit();
        
        session.close();

    }
}
