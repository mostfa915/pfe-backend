package com.pfe.demo.controller;

import com.pfe.demo.entiter.Categories;
import com.pfe.demo.reposetory.CategorieReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/categorie")
public class CategorieController {
@Autowired
    CategorieReposetory categorieReposetory;
    @GetMapping("/all")
    List<Categories> getAll() {
        return categorieReposetory.findAll();
    }

    @PostMapping("/addcategorie")
    Categories Ajouter(@RequestBody Categories categorie) {
        return categorieReposetory.save(categorie);
    }

    @PutMapping("/update/{id}")
    public Categories update(@RequestBody Categories categorie, @PathVariable Long id) {
        categorie.setId(id);
        return categorieReposetory.saveAndFlush(categorie);
    }

    @DeleteMapping("/delete/{Id}")
    public HashMap<String, String> delete(@PathVariable Long Id) {
        HashMap hashmap = new HashMap();
        try {
            categorieReposetory.deleteById(Id);
            hashmap.put("etat", "suprimer");

        } catch (Exception e) {
            hashmap.put("etat", " non  suprimer");
        }
        return hashmap;

    }
    @GetMapping("/getone/{id}")
    Categories findbyId(@PathVariable Long id){
        return categorieReposetory.getOne(id);
    }

  /*  @GetMapping("/findbymc")
    List<Artisan> ChercherParMc(String mc){
        return categorieReposetory.chercher1("%"+mc+"%");
    }*/
}
