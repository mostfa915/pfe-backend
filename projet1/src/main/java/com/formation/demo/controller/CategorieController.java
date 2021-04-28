package com.formation.demo.controller;


import com.formation.demo.dao.CategorieReposetory;
import com.formation.demo.entites.Admin;
import com.formation.demo.entites.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
@RestController
@RequestMapping("/categorie")
public class CategorieController {
    @Autowired
    private  CategorieReposetory  cx  ;

    @GetMapping("/all")
    public List<Categorie> Getall() {
        return cx.findAll();
    }

    @PostMapping("/save")
    public Categorie ajouter(@RequestBody Categorie c) {
        return cx.save(c);
    }

    @PutMapping("/update/{id}")
    public Categorie  update(@RequestBody Categorie c, @PathVariable Long id) {
        c.setId(id);
        return cx.saveAndFlush(c);
    }

    @DeleteMapping("/delete/{Id}")
    public HashMap<String, String> delete(@PathVariable Long Id) {
        HashMap hashmap = new HashMap();
        try {
            cx.deleteById(Id);
            hashmap.put("etat", "suprimer");

        } catch (Exception e) {
            hashmap.put("etat", " non  suprimer");
        }
        return hashmap;
    }
}
