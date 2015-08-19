package com.firstbit.layer;

import java.util.List;

import com.firstbit.pojo.Contacts;

public interface ContactsDAO {

  public List<Contacts> getContactsByUserId(String userId);
  public void saveContact(Contacts contact);
  public Contacts getContactByContactId(String contactId);
  public void removeContactByContactId(String contactId);
  
}
