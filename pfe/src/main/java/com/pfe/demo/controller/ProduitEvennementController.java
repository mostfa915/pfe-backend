package com.pfe.demo.controller;

import com.pfe.demo.entiter.Fournisseur;
import com.pfe.demo.entiter.ProduitEvennement;
import com.pfe.demo.reposetory.FournisseurReposetory;
import com.pfe.demo.reposetory.ProduitEvennementReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class ProduitEvennementController {
    @Autowired
    private ProduitEvennementReposetory produitEvennementReposetory ;
    @GetMapping("/all")
    List<ProduitEvennement> getAll() {
        return produitEvennementReposetory.findAll();
    }
    @GetMapping("/oneById/{id}")
    ProduitEvennement getOnebyid(@PathVariable Long id) {
        return produitEvennementReposetory.findbyId(id);
    }
    @PostMapping("/addProduit")
    ProduitEvennement Ajouter(@RequestBody ProduitEvennement produitEvennement) {
        return produitEvennementReposetory.save(produitEvennement);
    }

    @PutMapping("/update/{id}")
    public ProduitEvennement update(@RequestBody ProduitEvennement produitEvennement, @PathVariable Long id) {
        produitEvennement.setId(id);
        return produitEvennementReposetory.saveAndFlush(produitEvennement);
    }

    @DeleteMapping("/delete/{Id}")
    public HashMap<String, String> delete(@PathVariable Long Id) {
        HashMap hashmap = new HashMap();
        try {
            produitEvennementReposetory.deleteById(Id);
            hashmap.put("etat", "suprimer");

        } catch (Exception e) {
            hashmap.put("etat", " non  suprimer");
        }
        return hashmap;

    }
    @GetMapping("/getone/{id}")
    ProduitEvennement findbyId(@PathVariable Long id){
        return produitEvennementReposetory.getOne(id);
    }
    /*@GetMapping("/findbymc")
    List<Fournisseur> ChercherParMc(String mc){
        return produitEvennementReposetory.chercher1("%"+mc+"%");
    }*/

}
