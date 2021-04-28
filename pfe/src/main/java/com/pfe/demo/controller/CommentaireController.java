package com.pfe.demo.controller;

import com.pfe.demo.entiter.Clients;
import com.pfe.demo.entiter.Commentaire;
import com.pfe.demo.entiter.Produit;
import com.pfe.demo.entiter.Utilisateur;
import com.pfe.demo.reposetory.ClientReposetory;
import com.pfe.demo.reposetory.CommentaireReposetory;
import com.pfe.demo.reposetory.ProduitReposetory;
import com.pfe.demo.reposetory.UtilisateurReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/commentaire")

public class CommentaireController {
@Autowired
    private CommentaireReposetory commentaireReposetory;
@Autowired
private ProduitReposetory produitReposetory;
@Autowired
private ClientReposetory clientReposetory;
@Autowired
private UtilisateurReposetory utilisateurReposetory;
    @GetMapping("/all")
    List<Commentaire> getAll() {
        return commentaireReposetory.findAll();
    }
    @PostMapping("/add")
   Commentaire Ajouter(@RequestBody Commentaire commentaire) {
        System.out.println("x"+commentaire.getCommentaire());
Produit p= new Produit();
p=produitReposetory.findbyId(commentaire.getIdProd());
commentaire.setIdproduit(p);
        Utilisateur c= new Utilisateur();
         c=utilisateurReposetory.findbyname(commentaire.getNomclient());
      commentaire.setIdUtilisateur(c);

        return commentaireReposetory.save(commentaire);

    }

    @GetMapping("/count")
    Long counts(){
        return commentaireReposetory.countallcomment();
    }
    @GetMapping("/getcomments/{id}")
    List<Commentaire> findbyId(@PathVariable Long id){
        return commentaireReposetory.findcommentairesbyidProduit(id);
    }
    @DeleteMapping("/delete/{Id}")
    public HashMap<String, String> delete(@PathVariable Long Id) {
        HashMap hashmap = new HashMap();
        try {
            commentaireReposetory.deleteById(Id);
            hashmap.put("etat", "suprimer");

        } catch (Exception e) {
            hashmap.put("etat", " non  suprimer");
        }
        return hashmap;

    }

}
