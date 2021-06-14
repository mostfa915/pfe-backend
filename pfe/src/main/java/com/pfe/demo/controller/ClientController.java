package com.pfe.demo.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pfe.demo.Services.CompteServices;
import com.pfe.demo.entiter.*;
import com.pfe.demo.reposetory.ClientReposetory;
import com.pfe.demo.reposetory.EmplacementReposetory;
import com.pfe.demo.reposetory.RolesReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

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
    @Autowired
    private EmplacementReposetory emplacementReposetory;
    private final Path rootLocation = Paths.get("images");

    @GetMapping("/all")
    List<Clients> getAll() {
        return clientReposetory.findAll();
    }
        @PostMapping("/addclient")
        public Clients ajouter(@RequestParam("longitude") String longitude,@RequestParam("latitude") String latitude,@RequestParam("artisan1") String client) throws IOException, JsonParseException, JsonMappingException
        {
            Clients a = new ObjectMapper().readValue(client, Clients.class);
            System.out.println(a.getDateinscription());
            System.out.println(rootLocation.toString());
            boolean isExist = new File(rootLocation.toString()).exists();
            System.out.println(longitude);
            if (!isExist) {
                Files.createDirectory(rootLocation);
                System.out.println("mk Dir"); }
            System.out.println(a.getUsername());
            Utilisateur artisan1= (Utilisateur) compteServices.FindUserByUsername(a.getUsername());
            if(artisan1!=null)throw new RuntimeException("username exist");
            Clients artisan2=new Clients();
            Emplacement emp=new Emplacement();
            emp.setAltetude(latitude);
            emp.setLongetude(longitude);
            emp.setNomville(a.getVille());
            emplacementReposetory.save(emp);
            artisan2.setUsername(a.getUsername());
            artisan2.setPassword(a.getPassword());
            artisan2.setPrenom(a.getPrenom());
            artisan2.setEmail(a.getEmail());
            artisan2.setVille(a.getVille());
            artisan2.setDateinscription(a.getDateinscription());
           artisan2.setTel(a.getTel());
            Roles role =rolesReposetory.findByRoleNom("CLIENT");
            artisan2.getRoles().add(role);
            artisan2.setPhotodeprofil("user.png");
            artisan2.setEmplacementid(emp);
            return(Clients) compteServices.saveUser(artisan2);

            //    }
            //  else{
            //    return new ResponseEntity<Response>(new Response(" not saved"), HttpStatus.BAD_REQUEST);

        }
    @GetMapping("/getone/{id}")
   Clients findbyId(@PathVariable Long id){
        return clientReposetory.getOne(id);
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