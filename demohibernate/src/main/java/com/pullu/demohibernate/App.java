package com.pullu.demohibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        
        HumanName hm = new HumanName();
        
        hm.setFname("Pulkit");
        hm.setLname("Jain");
        hm.setMname("");
        
        Human human = new Human();
        
        human.setId(4);
        human.setName(hm);
        human.setColor("yellow");
        
        
        Configuration con =  new Configuration().configure().addAnnotatedClass(Human.class);
        
        //New changes
            
        SessionFactory sf = con.buildSessionFactory();
        
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        
        session.save(human);
        
        tx.commit();
        
    }
}
