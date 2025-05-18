package com.example.pfev2.controllers;

import com.example.pfev2.entites.Utilisateur;
import com.example.pfev2.repositorys.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/auth")
public class AuthController {



    @Autowired
    private UtilisateurRepository repo;

/*
    @PostMapping("/login")
    public String login(@RequestBody Utilisateur request) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getMdpHash())
        );
        return jwtUtil.generateToken(request.getEmail());
    }*/

    @PostMapping("/register")
    public String register(@RequestBody Utilisateur request) {
        Utilisateur user = new Utilisateur();
        user.setEmail(request.getEmail());
        user.setMdpHash(request.getMdpHash()); // encode password
        user.setRole(request.getRole());
        user.setNum(request.getNum());
        repo.save(user);
        return "Utilisateur enregistré";
    }
}