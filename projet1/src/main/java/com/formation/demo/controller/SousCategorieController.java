package com.formation.demo.controller;


import com.formation.demo.dao.SousCategorieReposetory;
import com.formation.demo.entites.SousCategorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
@RequestMapping("/souscategorie")
@RestController
public class SousCategorieController {
    @Autowired
    private SousCategorieReposetory cx  ;

    @GetMapping("/all")
    public List<SousCategorie> Getall() {
        return cx.findAll();
    }

    @PostMapping("/save")
    public SousCategorie ajouter(@RequestBody SousCategorie  c) {
        return cx.save(c);
    }

    @PutMapping("/update/{id}")
    public SousCategorie  update(@RequestBody SousCategorie c, @PathVariable Long id) {
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
