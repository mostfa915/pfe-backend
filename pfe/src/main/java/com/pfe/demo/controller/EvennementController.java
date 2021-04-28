package com.pfe.demo.controller;
import com.pfe.demo.entiter.Evennement;
import com.pfe.demo.reposetory.EvennementReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/evennement")
public class EvennementController {

@Autowired
private EvennementReposetory evennementReposetory;


    @GetMapping("/all")
    List<Evennement> getAll() {
        return evennementReposetory.findAll();
    }
    @GetMapping("/oneById/{id}")
    Optional<Evennement> getOnebyid(@PathVariable Long id) {
        return evennementReposetory.findById(id);
    }
    @PostMapping("/add")
    Evennement Ajouter(@RequestBody Evennement evennement) {
        return evennementReposetory.save(evennement);
    }

}


