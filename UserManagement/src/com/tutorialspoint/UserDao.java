package com.tutorialspoint;  

import java.util.ArrayList;
import java.util.List;  

public class UserDao { 
   public List<User> getAllUsers(){ 
      
      List<User> userList = null; 
      User user = new User(1, "Mahesh", "Teacher"); 
      userList = new ArrayList<User>(); 
      userList.add(user);
         
      return userList; 
   } 
}