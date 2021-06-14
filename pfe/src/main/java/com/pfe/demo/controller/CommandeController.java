package com.pfe.demo.controller;

import com.pfe.demo.entiter.*;
import com.pfe.demo.reposetory.ClientReposetory;
import com.pfe.demo.reposetory.CommandeReposetory;
import com.pfe.demo.reposetory.PannierReposetory;
import com.pfe.demo.reposetory.ProduitReposetory;
import com.sun.mail.iap.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/commande")
public class CommandeController {
    @Autowired
    private CommandeReposetory commandeReposetory;
@Autowired
private PannierReposetory pannierReposetory;
@Autowired
private ClientReposetory clientReposetory;
@Autowired
private ProduitReposetory produitReposetory;
    @GetMapping("/all")
    List<Commande> getAll() {
        return commandeReposetory.findAll();
    }
    @GetMapping("/oneById/{id}")
    Commande getOnebyid(@PathVariable Long id) {
        return commandeReposetory.findbyId(id);
    }


    @GetMapping("/onebycode/{code}")
    Commande getOnebycode(@PathVariable Long code) {
        return commandeReposetory.findbycode(code);
    }
 /*   @PostMapping("/save")
    public ResponseEntity<Response> Ajouter(@Valid @RequestBody Commande commande) {


        commandeReposetory.save(commande);
        List<Pannier> lpannier = commande.getlPanniers();
       System.out.println(lpannier);
        for (Pannier lc : lpannier) {
            lc.getIdc(commande.getId());
            pannierReposetory.save(lc);



        }
        return new ResponseEntity<Response>(new Response("saved"), HttpStatus.OK);
    }*/

    @PostMapping("/save")
    public Commande Ajouter(@RequestBody Commande commande) {
        System.out.println(commande.getNom());
               Utilisateur clients=clientReposetory.findbyname(commande.getNom());
         System.out.println(clients.getId());
        commande.setIdClient(clients);
        Commande c=  commandeReposetory.save(commande);
        c.setAdressedelivraison(commande.getAdressedelivraison());
        clients.getClientCommandes().add(commande);
        Collection<Pannier> lpannier = commande.getLpanniers();
        for (Pannier lc : lpannier) {
            lc.setDatepannier(commande.getDatecommande());
            lc.setIdCommande(commande);
            lc.setIdproduit(produitReposetory.findbyId(lc.getId()));
            pannierReposetory.save(lc);
        }
        return  c;

    }

    @PutMapping("/update/{id}")
    public Commande update(@RequestBody Commande commande, @PathVariable Long id) {
        commande.setId(id);
        return commandeReposetory.saveAndFlush(commande);
    }


    @DeleteMapping("/delete/{Id}")
    public HashMap<String, String> delete(@PathVariable Long Id) {
        HashMap hashmap = new HashMap();
        try {
            commandeReposetory.deleteById(Id);
            hashmap.put("etat", "suprimer");

        } catch (Exception e) {
            hashmap.put("etat", " non  suprimer");
        }
        return hashmap;

    }

    @GetMapping("/count")
    Long counts(){
        return commandeReposetory.countallCommande();
    }
    @GetMapping("/desc")
    List<Commande> desc(){
        return commandeReposetory.alldesc();
    }
    @GetMapping("/cmdmm/{date}")
    List<Commande> cmdmm(@PathVariable String date){
        return commandeReposetory.commandederniermm(date);
    }
    @GetMapping("/commandeclient/{id}")
    List<Commande> cmdmm(@PathVariable Long id){
        return commandeReposetory.commandeclient(id);
    }

}
