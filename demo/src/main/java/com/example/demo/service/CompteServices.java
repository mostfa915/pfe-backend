package com.example.demo.service;

import com.example.demo.Entiter.RoleApp;
import com.example.demo.Entiter.UserApp;

public interface CompteServices {
public UserApp saveUser( UserApp user);
public RoleApp saveRole(RoleApp role);
public  void AddRoleToUser(String username ,String userRole);
public UserApp FindUserByUsername(String username);
}
