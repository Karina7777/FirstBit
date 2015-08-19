package com.firstbit.registery;

import com.firstbit.implementation.ContactsDAO;
import com.firstbit.implementation.UsersDAO;


public class Regitstery {
  
  public static com.firstbit.layer.ContactsDAO contacts;
  public static com.firstbit.layer.UsersDAO users;
  
  static{
    contacts = new ContactsDAO();
    users = new UsersDAO();
  }

  public static com.firstbit.layer.ContactsDAO getContacts() {
    return contacts;
  }

  public static void setContacts(com.firstbit.layer.ContactsDAO contacts) {
    Regitstery.contacts = contacts;
  }

  public static com.firstbit.layer.UsersDAO getUsers() {
    return users;
  }

  public static void setUsers(com.firstbit.layer.UsersDAO users) {
    Regitstery.users = users;
  }
  
}
