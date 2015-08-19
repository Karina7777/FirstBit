package com.firstbit.layer;

import java.util.List;

import com.firstbit.pojo.Users;

public interface UsersDAO {
  
  public List <Users> getAllUsers();
  public Users getUserById(String id);
  public void saveUser(Users user);
  public void removeUser(String id);

}
