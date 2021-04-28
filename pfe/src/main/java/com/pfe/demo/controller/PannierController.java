package com.pfe.demo.controller;

import com.pfe.demo.entiter.Categories;
import com.pfe.demo.entiter.Pannier;
import com.pfe.demo.reposetory.PannierReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

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

    @PutMapping("/update/{id}")
    public Pannier update(@RequestBody Pannier pannier, @PathVariable Long id) {
        pannier.setId(id);
        return pannierReposetory.saveAndFlush(pannier);
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
    Pannier findbyId(@PathVariable Long id){
        return pannierReposetory.getOne(id);
    }
}
