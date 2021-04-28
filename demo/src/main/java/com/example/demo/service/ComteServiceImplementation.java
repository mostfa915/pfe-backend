package com.example.demo.service;

import com.example.demo.Dao.RoleAppReposetory;
import com.example.demo.Dao.UserAppReposetory;
import com.example.demo.Entiter.RoleApp;
import com.example.demo.Entiter.UserApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ComteServiceImplementation implements CompteServices {
   @Autowired
    private BCryptPasswordEncoder  bCryptPasswordEncoder;
@Autowired
private UserAppReposetory userAppReposetory ;
@Autowired
private RoleAppReposetory roleAppReposetory;
    @Override
    public UserApp saveUser(UserApp user) {
       /* crypter le mot de passe avant mettres le user dans la bdd */
        String hashPassword =bCryptPasswordEncoder.encode(user.getPassword());
     user.setPassword(hashPassword);
     return userAppReposetory.save(user);

    }

    @Override
    public RoleApp saveRole(RoleApp role) {
        return roleAppReposetory.save(role);
    }

    @Override
    public void AddRoleToUser(String username, String rolename) {
/*rcuperer le role */
  RoleApp role =roleAppReposetory.findByRoleName(rolename);
  /*recuprer le user qui je veux ajouter un role*/
  UserApp user=userAppReposetory.findByUsername(username);
  /*affecter le role aux user*/
  user.getRoles().add(role);
  }

    @Override
    public UserApp FindUserByUsername(String username) {
        return userAppReposetory.findByUsername(username);
    }
}
