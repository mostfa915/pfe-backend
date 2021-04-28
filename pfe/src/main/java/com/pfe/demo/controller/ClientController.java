package com.pfe.demo.controller;

import com.pfe.demo.Services.CompteServices;
import com.pfe.demo.entiter.Clients;
import com.pfe.demo.entiter.Fournisseur;
import com.pfe.demo.entiter.Roles;
import com.pfe.demo.entiter.Utilisateur;
import com.pfe.demo.reposetory.ClientReposetory;
import com.pfe.demo.reposetory.RolesReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

@CrossOrigin("*")
@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientReposetory clientReposetory;
    @Autowired
    private CompteServices compteServices;
    @Autowired
    private RolesReposetory rolesReposetory;
    private final Path rootLocation = Paths.get("images");


    @PostMapping("/addclient")
    public Clients regitrer(@RequestBody Clients client) {

        Clients client1 = (Clients) compteServices.FindUserByUsername(client.getUsername());
        if (client1 != null) throw new RuntimeException("username exist");


        Clients client2 = new Clients();
        client2.setUsername(client.getUsername());
        client2.setPassword(client.getPassword());
        client2.setPrenom(client.getPrenom());
        client2.setEmail(client.getEmail());
        client2.setCodepostale(client.getCodepostale());
        client2.setVille(client.getVille());
        client2.setAdresse(client.getAdresse());
        client2.setPhotodeprofil("user.png");
        Roles role = rolesReposetory.findByRoleNom("CLIENT");
        client2.getRoles().add(role);

        return (Clients) compteServices.saveUser(client2);
    }

    @DeleteMapping("/deleteall")
    public HashMap<String, String> delete() {
        HashMap hashmap = new HashMap();
        try {
            clientReposetory.deleteAll();
            hashmap.put("etat", "suprimer");

        } catch (Exception e) {
            hashmap.put("etat", " non  suprimer");
        }
        return hashmap;
    }
    public Utilisateur trouver(String nom){
        return clientReposetory.findbyname(nom);
    }

    @GetMapping("/img")
    public byte[]getPhoto() throws Exception{

        return Files.readAllBytes(Paths.get(rootLocation +"/"+"user.png"));
    }

}