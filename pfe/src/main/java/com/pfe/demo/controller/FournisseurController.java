package com.pfe.demo.controller;

import com.pfe.demo.Services.CompteServices;
import com.pfe.demo.entiter.Artisan;
import com.pfe.demo.entiter.Commande;
import com.pfe.demo.entiter.Fournisseur;
import com.pfe.demo.entiter.Roles;
import com.pfe.demo.reposetory.FournisseurReposetory;
import com.pfe.demo.reposetory.RolesReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/fournisseur")

public class FournisseurController {
   @Autowired
    private FournisseurReposetory fournisseurReposetory ;
   @Autowired
   private CompteServices compteServices;
   @Autowired
   private RolesReposetory rolesReposetory;
   private
   @GetMapping("/all")
    List<Fournisseur> getAll() {
        return fournisseurReposetory.findAll();
    }
    @GetMapping("/oneById/{id}")
    Fournisseur getOnebyid(@PathVariable Long id) {
        return fournisseurReposetory.findbyId(id);
    }

    @PostMapping("/addfournisseur")
    public Fournisseur regitrer (@RequestBody Fournisseur fournisseur){

        Fournisseur fournisseur1= (Fournisseur) compteServices.FindUserByUsername(fournisseur.getUsername());
        if(fournisseur1!=null)throw new RuntimeException("username exist");



        Fournisseur fournisseur2=new Fournisseur();
        fournisseur2.setUsername(fournisseur.getUsername());
        fournisseur2.setPassword(fournisseur.getPassword());
        fournisseur2.setPrenom(fournisseur.getPrenom());
        fournisseur2.setEmail(fournisseur.getEmail());

        Roles role =rolesReposetory.findByRoleNom("FOURNISSEUR");
        fournisseur2.getRoles().add(role);

        return (Fournisseur) compteServices.saveUser(fournisseur2);
    }

    @PutMapping("/update/{id}")
    public Fournisseur update(@RequestBody Fournisseur fournisseur, @PathVariable Long id) {
        fournisseur.setId(id);
        return fournisseurReposetory.saveAndFlush(fournisseur);
    }

    @DeleteMapping("/delete/{Id}")
    public HashMap<String, String> delete(@PathVariable Long Id) {
        HashMap hashmap = new HashMap();
        try {
            fournisseurReposetory.deleteById(Id);
            hashmap.put("etat", "suprimer");

        } catch (Exception e) {
            hashmap.put("etat", " non  suprimer");
        }
        return hashmap;

    }
    @GetMapping("/getone/{id}")
    Fournisseur findbyId(@PathVariable Long id){
        return fournisseurReposetory.getOne(id);
    }
    @GetMapping("/findbymc")
    List<Fournisseur> ChercherParMc(String mc){
        return fournisseurReposetory.chercher1("%"+mc+"%");
    }
}
