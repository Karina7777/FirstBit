package com.firstbit.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.firstbit.pojo.Contacts;
import com.firstbit.pojo.Users;
import com.firstbit.registery.Regitstery;

@Controller
public class ContactsController {
  
  @RequestMapping(value="/contacts/{userId}", method=RequestMethod.GET)
  public ModelAndView showContacts(@PathVariable("userId") String userId){
    
    ModelAndView mav = new ModelAndView("contacts");
    Users user = Regitstery.getUsers().getUserById(userId);
    List<Contacts> contacts = Regitstery.getContacts().getContactsByUserId(userId);
    mav.addObject("contacts", contacts);
    return mav;
  }
  
  @RequestMapping(value="/add_new_contact/{userId}", method=RequestMethod.GET)
  public ModelAndView newContact(){
    ModelAndView mav = new ModelAndView("new_contact");
    return mav;
  }
  
  @RequestMapping(value="/add_new_contact/{userId}", method=RequestMethod.POST)
  public ModelAndView createContact(@PathVariable("userId") String userId, HttpServletRequest request){
    ModelAndView mav = new ModelAndView("new_contact");
    try {
      if(request.getParameter("username") == ""){
        mav.addObject("message", "Name can't be empty.");
        return mav;
      }
      
      Users user = Regitstery.getUsers().getUserById(userId);
      
      Contacts contact = new Contacts();
      contact.setName(request.getParameter("username"));
      contact.setEmail(request.getParameter("email"));
      contact.setTelephone(request.getParameter("telephone"));
      contact.setUser(user);
      
      Regitstery.getContacts().saveContact(contact);
      mav.addObject("message", "Contact was created is successfully.");
      return mav; 
    }
    catch(Exception e){
      mav.addObject("message", "Some problems. Try again");
      e.printStackTrace();
      return mav;
    }     
  }
  
  @ResponseBody
  @RequestMapping(value="/delete_contact", method=RequestMethod.POST)
  public String deleteContact(HttpServletRequest request){
    try{
      String contactId = request.getParameter("contactId");
      Regitstery.getContacts().removeContactByContactId(contactId);
      return "User deleted";
    }
    catch(Exception e){
      e.printStackTrace();
      return "Try again";
    }
  }

}
