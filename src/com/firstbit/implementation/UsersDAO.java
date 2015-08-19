package com.firstbit.implementation;

import java.util.List;

import org.hibernate.Session;
import com.firstbit.pojo.Users;
import com.firstbit.registery.Regitstery;

public class UsersDAO implements com.firstbit.layer.UsersDAO {
  
  public List <Users> getAllUsers(){
    
    Session session = HibernateConnection.doHibernateConnection().openSession();    
    List<Users> allUsers = session.createQuery("From Users").list();
    session.close();
    return allUsers;    
  }

  public Users getUserById(String id){
    
    try{
      Session session = HibernateConnection.doHibernateConnection().openSession();
      List<Users> product = session.createQuery("From Users where id='"+id+"' ").list();
      session.close();
      return product.get(0);
    }
    catch(Exception e){
      e.printStackTrace();
      return null;
    }
  }
  
  public void saveUser(Users user){
    Session session = HibernateConnection.doHibernateConnection().openSession();
    session.beginTransaction();
    session.save(user);
    session.getTransaction().commit();
    session.close();
  }
  
  public void removeUser(String id){
    try{
      Session session = HibernateConnection.doHibernateConnection().openSession();
      Users user = Regitstery.getUsers().getUserById(id);
      if(user != null){
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
        session.close();
      }
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }

}
