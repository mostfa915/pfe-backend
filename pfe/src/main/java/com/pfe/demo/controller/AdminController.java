package com.pfe.demo.controller;

import com.pfe.demo.Services.CompteServices;
import com.pfe.demo.entiter.Admin;

import com.pfe.demo.entiter.Artisan;
import com.pfe.demo.entiter.Produit;
import com.pfe.demo.entiter.Roles;
import com.pfe.demo.reposetory.AdminReposetory;
import com.pfe.demo.reposetory.RolesReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private CompteServices compteServices;
  @Autowired
    private RolesReposetory rolesReposetory;
@Autowired
private AdminReposetory adminReposetory;
    @GetMapping("/all")
    List<Admin> getAll() {
        return adminReposetory.findAll();
    }
    @PostMapping("/addadmin")
    public Admin regitrer (@RequestBody Admin admin){

        Admin admin1= (Admin) compteServices.FindUserByUsername(admin.getUsername());
        if(admin1!=null)throw new RuntimeException("username exist");



        Admin admin2=new Admin();
        admin2.setUsername(admin.getUsername());
        admin2.setPassword(admin.getPassword());
        admin2.setPrenom(admin.getPrenom());
        admin2.setEmail(admin.getEmail());

        Roles role =rolesReposetory.findByRoleNom("ADMIN");
        admin2.getRoles().add(role);
        Roles role2 =rolesReposetory.findByRoleNom("USER");
        admin2.getRoles().add(role2);
        admin2.setPhotodeprofil("user.png");
        return (Admin) compteServices.saveUser(admin2);
    }

}
