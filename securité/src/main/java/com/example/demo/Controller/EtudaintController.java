package com.example.demo.Controller;

import com.example.demo.Dao.EtudaintReposetory;
import com.example.demo.Model.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/etudiant")
public class EtudaintController {
    @Autowired
    private EtudaintReposetory  etu  ;

    @GetMapping("/all")
    public List<Etudiant> Getall() {
        return etu.findAll();
    }

    @PostMapping("/save")
    public Etudiant ajouter(@RequestBody Etudiant e) {
        return etu.save(e);
    }

    @PutMapping("/update/{id}")
    public Etudiant  update(@RequestBody Etudiant e, @PathVariable Long id) {
        e.setId(id);
        return etu.saveAndFlush(e);
    }


    @DeleteMapping("/delete/{Id}")
    public HashMap<String, String> delete(@PathVariable Long Id) {
        HashMap hashmap = new HashMap();
        try {
            etu.deleteById(Id);
            hashmap.put("etat", "suprimer");

        } catch (Exception e) {
            hashmap.put("etat", " non  suprimer");
        }
        return hashmap;
    }
}
