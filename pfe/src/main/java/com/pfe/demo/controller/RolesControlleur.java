package com.pfe.demo.controller;

import com.pfe.demo.entiter.Commande;
import com.pfe.demo.entiter.Roles;
import com.pfe.demo.reposetory.RolesReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RolesControlleur {
@Autowired
    private RolesReposetory rolesReposetory;

    @PostMapping("/addroles")
    Roles Ajouter(@RequestBody Roles role) {
        return rolesReposetory.save(role);
    }

}
