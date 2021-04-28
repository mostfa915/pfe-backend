package com.pfe.demo.controller;

import com.pfe.demo.entiter.Emplacement;
import com.pfe.demo.reposetory.EmplacementReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/emplacement")
public class EmplacementController {
@Autowired
    private EmplacementReposetory emplacementReposetory;
    @GetMapping("/all")
    List<Emplacement> getAll() {
        return emplacementReposetory.findAll();
    }
}
