package com.pfe.demo.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pfe.demo.entiter.Produit;
import com.pfe.demo.reposetory.ArtisanReposetory;
import com.pfe.demo.reposetory.ProduitReposetory;
import com.sun.mail.iap.Response;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/produit")

public class ProduitController {
    private final Path rootLocation = Paths.get("images");

    @Autowired
    private ProduitReposetory produitReposetory;
    @Autowired
    private ArtisanReposetory artisanReposetory;

    @GetMapping("/all")
    List<Produit> getAll()
    {
        return produitReposetory.findAll();
    }

   @PostMapping("/ajouter")
   Produit Ajouter2(@RequestBody Produit produit) {
       return produitReposetory.save(produit);
   }
    @PostMapping("/save")
    public ResponseEntity<Response> ajouter(@RequestParam("file")MultipartFile file, @RequestParam("product") String product) throws IOException,JsonParseException,JsonMappingException
    {
        Produit p = new ObjectMapper().readValue(product, Produit.class);
        System.out.println(rootLocation.toString());
        boolean isExist = new File(rootLocation.toString()).exists();
        if (!isExist) {
            Files.createDirectory(rootLocation);
            System.out.println("mk Dir");
       }
        String filename = file.getOriginalFilename();
        String newfilename= FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
        Files.copy(file.getInputStream(), this.rootLocation.resolve(newfilename));
        p.setFileName(newfilename);
       p.setIdArtisan(artisanReposetory.findbyId((long) p.getIdd()));
        System.out.println(newfilename);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        p.setDateajout(dtf.format(now));
        produitReposetory.save(p);
        if(p != null) {
            return new ResponseEntity<Response>(new Response("saved"), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<Response>(new Response(" not saved"), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/imgArticle/{id}")
    public byte[]getPhoto(@PathVariable("id")Long id) throws Exception{
        Produit product=produitReposetory.findbyId(id);
        //return Files.readAllBytes(Paths.get(context.getRealPath("/images/") + product.getFileName()));
        return Files.readAllBytes(Paths.get(rootLocation +"/"+ product.getFileName()));
    }

    @PutMapping("/update/{id}")
    public Produit update(@RequestBody Produit c, @PathVariable Long id) {
        c.setId(id);
        return produitReposetory.saveAndFlush(c);
    }

    @DeleteMapping("/delete/{Id}")
    public HashMap<String, String> delete(@PathVariable Long Id) {
        HashMap hashmap = new HashMap();
        try {
            produitReposetory.deleteById(Id);
            hashmap.put("etat", "suprimer");

        } catch (Exception e) {
            hashmap.put("etat", " non  suprimer");
        }
        return hashmap;

    }
    @GetMapping("/getone/{id}")
    Produit findbyId(@PathVariable Long id){
        return produitReposetory.getOne(id);
    }
    @GetMapping("/countproduitbyartisan/{id}")
    Long countproduitbyartisan(@PathVariable Long id)
    {
        return produitReposetory.countprouitartisan(id);
    }

    @GetMapping("/getbyarti/{id}")
   List<Produit> findbyIdart(@PathVariable Long id){
        return produitReposetory.findProductbyartisa(id);
    }

    @GetMapping("/getbyartisandesc/{id}")
    List<Produit> findbyIdartisandesc(@PathVariable Long id){
        return produitReposetory.findProductbyartisandec(id);
    }
    @GetMapping("/findbymc")
    List<Produit> ChercherParMc(String mc){
        return produitReposetory.chercher("%"+mc+"%");
    }

    @GetMapping("/count")
    Long counts(){
        return produitReposetory.countallproduits();
    }
    @GetMapping("/desc")
    List<Produit> desc(){
        return produitReposetory.alldesc();
    }
}
