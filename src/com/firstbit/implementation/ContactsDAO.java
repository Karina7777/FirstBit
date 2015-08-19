package com.firstbit.implementation;

import java.util.List;

import org.hibernate.Session;

import com.firstbit.pojo.Contacts;
import com.firstbit.pojo.Users;
import com.firstbit.registery.Regitstery;

public class ContactsDAO implements com.firstbit.layer.ContactsDAO  {
  
  public List<Contacts> getContactsByUserId(String userId){
    try {
      Session session = HibernateConnection.doHibernateConnection().openSession();
      List <Contacts> contacts = session.createQuery("From Contacts where id_user='"+userId+"' ").list();
      session.close();
      return contacts;
    }
    catch(Exception e) {
      e.printStackTrace();
      return null;
    }
  }
  
  public void saveContact(Contacts contact){    
    Session session = HibernateConnection.doHibernateConnection().openSession();
    session.beginTransaction();
    session.save(contact);
    session.getTransaction().commit();
    session.close();
  }
  
  public Contacts getContactByContactId(String contactId){    
    try {
      Session session = HibernateConnection.doHibernateConnection().openSession();
      List <Contacts> contact = session.createQuery("From Contacts where id='"+contactId+"' ").list();
      session.close();
      return contact.get(0);
    }
    catch(Exception e) {
      e.printStackTrace();
      return null;
    }
  }
  
  public void removeContactByContactId(String contactId){
    
    try {
      Session session = HibernateConnection.doHibernateConnection().openSession();
      Contacts contact = Regitstery.getContacts().getContactByContactId(contactId);
      session.beginTransaction();
      session.delete(contact);
      session.getTransaction().commit();
      session.close();
    }
    
    catch(Exception e) {
      e.printStackTrace();
      
    }
    
  }

}
