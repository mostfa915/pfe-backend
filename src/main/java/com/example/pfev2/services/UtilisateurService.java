package com.example.pfev2.services;

import com.example.pfev2.entites.Utilisateur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
public class UtilisateurService {

    @PersistenceContext
    private EntityManager entityManager;

    public UtilisateurService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void insererUtilisateur(String num, String email, String mdpHash, Utilisateur.Role role) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNum(num);
        utilisateur.setEmail(email);
        utilisateur.setMdpHash(mdpHash);
        utilisateur.setRole(role);

        entityManager.persist(utilisateur); // Spring gère la transaction automatiquement
    }
}

