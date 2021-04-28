package com.pfe.demo.Services;

import com.pfe.demo.entiter.Admin;
import com.pfe.demo.entiter.Utilisateur;
import com.pfe.demo.entiter.Roles;

public interface CompteServices {
    public Utilisateur saveUser(Utilisateur utilisateur);
    public Roles saveRole(Roles role);
    public  void AddRoleToUser(String username ,String userRole);
    public Utilisateur FindUserByUsername(String utilsateur);
}
