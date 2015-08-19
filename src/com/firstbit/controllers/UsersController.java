package com.firstbit.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.firstbit.pojo.Users;
import com.firstbit.registery.Regitstery;

@Controller
public class UsersController {
  
  @RequestMapping(value="/", method=RequestMethod.GET)
  public ModelAndView showUsers(){
    ModelAndView mav = new ModelAndView("index");
    List <Users> users = Regitstery.getUsers().getAllUsers();
    mav.addObject("AllUsers", users);
    return mav;
  }
  
  @RequestMapping(value="/create_new_user", method=RequestMethod.GET)
  public ModelAndView newUser(){
    ModelAndView mav = new ModelAndView("new_user");
    return mav;
  }
  
  @RequestMapping(value="/new_user", method=RequestMethod.POST)
  public ModelAndView createUser(HttpServletRequest request){
    ModelAndView mav = new ModelAndView("new_user");
    try {
      if(request.getParameter("username") == ""){
        mav.addObject("message", "Name can't be empty.");
        return mav;
      }
      Users user = new Users();
      user.setName(request.getParameter("username"));
      Regitstery.getUsers().saveUser(user);
      mav.addObject("message", "User was created is successfully.");
      return mav;
    }
    catch(Exception e){
      e.printStackTrace();
      mav.addObject("message", "Some problems. Try again");
      return mav;
    }
  }
  
  @ResponseBody
  @RequestMapping(name="/delete_user", method=RequestMethod.POST)                           
  public String deleteUser(HttpServletRequest request){    
    String userId = request.getParameter("userId");
    try{
      Regitstery.getUsers().removeUser(userId);
      return "User deleted";
    }
    catch(Exception e){
      e.printStackTrace();
      return "Try again";
    }
  }


}
