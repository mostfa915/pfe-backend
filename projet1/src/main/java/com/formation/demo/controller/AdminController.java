package com.formation.demo.controller;

import com.formation.demo.dao.AdminReposetory;
import com.formation.demo.dao.ProductReposetory;
import com.formation.demo.entites.Admin;
import com.formation.demo.entites.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

public class AdminController {
    @Autowired
    private AdminReposetory pr;

    @GetMapping("/all")
    public List<Admin> Getall() {
        return pr.findAll();
    }

    @PostMapping("/save")
    public Admin ajouter(@RequestBody Admin c) {
        return pr.save(c);
    }

    @PutMapping("/update/{id}")
    public Admin  update(@RequestBody Admin c, @PathVariable Long id) {
        c.setId(id);
        return pr.saveAndFlush(c);
    }

    @DeleteMapping("/delete/{Id}")
    public HashMap<String, String> delete(@PathVariable Long Id) {
        HashMap hashmap = new HashMap();
        try {
            pr.deleteById(Id);
            hashmap.put("etat", "suprimer");

        } catch (Exception e) {
            hashmap.put("etat", " non  suprimer");
        }
        return hashmap;
    }
}

