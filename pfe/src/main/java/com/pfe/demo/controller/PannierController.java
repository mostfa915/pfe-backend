package com.pfe.demo.controller;

import com.pfe.demo.entiter.Categories;
import com.pfe.demo.entiter.Clients;
import com.pfe.demo.entiter.Pannier;
import com.pfe.demo.entiter.Utilisateur;
import com.pfe.demo.reposetory.PannierReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/pannier")

public class PannierController {
    @Autowired
    private PannierReposetory pannierReposetory;

    @GetMapping("/all")
    List<Pannier> getAll() {
        return pannierReposetory.findAll();
    }

    @PostMapping("/addProduit")
    Pannier Ajouter(@RequestBody Pannier pannier) {
        return pannierReposetory.save(pannier);
    }

    @PostMapping("/passeraulivraison/{id}")
    Pannier passeraulivraison(@PathVariable Long id) {
       Pannier pannier=new Pannier();
              pannier= pannierReposetory.pannierbyid(id);
      System.out.println(pannier.getId());
       pannier.setEtat("Expédié");
        return pannierReposetory.save(pannier);
    }
    @PutMapping("/update/{id}")
    public Pannier update(@RequestBody Pannier pannier, @PathVariable Long id) {
        pannier.setId(id);
        return pannierReposetory.saveAndFlush(pannier);
    }

    @GetMapping("/cmdmm/{date}/{id}")
    List<Pannier> cmdmm(@PathVariable String date, @PathVariable Long id) {
        return pannierReposetory.commandedernierm(date, id);
    }


    @DeleteMapping("/delete/{Id}")
    public HashMap<String, String> delete(@PathVariable Long Id) {
        HashMap hashmap = new HashMap();
        try {
            pannierReposetory.deleteById(Id);
            hashmap.put("etat", "suprimer");

        } catch (Exception e) {
            hashmap.put("etat", " non  suprimer");
        }
        return hashmap;

    }

    @GetMapping("/getone/{id}")
    Pannier findbyId(@PathVariable Long id) {
        return pannierReposetory.getOne(id);
    }

    @GetMapping("/countpannierbyartisan/{id}")
    Long artisanclients(@PathVariable Long id) {
        return pannierReposetory.countclientpourartisan(id);
    }

    @GetMapping("/countclientbyartisan2/{id}")
    List<Utilisateur> artisanclients2(@PathVariable Long id) {
        return pannierReposetory.clientpourartisan(id);
    }
    @GetMapping("/countclientbyartisan3/{id}")
    List<Pannier> clientartisan(@PathVariable Long id) {
        return pannierReposetory.clientartisan(id);
    }
    @GetMapping("/desc")
    List<Pannier> desc(){
        return pannierReposetory.alldesc();
    }
    @GetMapping("/cmd/{id}")
    List<Pannier> desc(@PathVariable Long id){
        return pannierReposetory.pannierducommande(id);
    }

}

