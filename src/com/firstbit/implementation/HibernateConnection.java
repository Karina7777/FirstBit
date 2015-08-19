package com.firstbit.implementation;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.firstbit.pojo.Users;
import com.firstbit.pojo.Contacts;

public class HibernateConnection {
  
  public static SessionFactory sessionFactory;
  
  public static SessionFactory doHibernateConnection(){
    
    Properties database = new Properties();
    database.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
    database.setProperty("hibernate.connection.username", "root");
    database.setProperty("hibernate.connection.password", "");
    database.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/firstbit");
    database.setProperty("hibernate.connection.dialect", "org.hibernate.dialect.MySQL5Dialect");
    
    Configuration cfg = new Configuration().setProperties(database)
                                           .addPackage("com.firstbit.pojo")
                                           .addAnnotatedClass(Users.class)
                                           .addAnnotatedClass(Contacts.class);
    
    StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
    
    sessionFactory = cfg.buildSessionFactory(ssrb.build());
    return sessionFactory;
  }

}
