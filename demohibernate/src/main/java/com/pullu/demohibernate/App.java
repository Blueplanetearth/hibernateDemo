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
        
        Laptop laptop = new Laptop();
        laptop.setLid(101);
        laptop.setLname("Dell");
        
        Student student = new Student();
        student.setRollno(1);
        student.setName("Pulkit");
        student.setMarks(70);
        student.getLaptop().add(laptop);
        
        
        //Configuration con =  new Configuration().configure().addAnnotatedClass(Human.class);
        
        //New changes
        Configuration con =  new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
        
        SessionFactory sf = con.buildSessionFactory();
        
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        
        //session.save(human);
        session.save(laptop);
        session.save(student);
        
        
        tx.commit();
        
    }
}
