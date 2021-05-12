package com.pfe.demo.controller;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pfe.demo.Services.CompteServices;
import com.pfe.demo.entiter.*;
import com.pfe.demo.reposetory.ArtisanReposetory;
import com.pfe.demo.reposetory.EmplacementReposetory;
import com.pfe.demo.reposetory.RolesReposetory;
import com.pfe.demo.reposetory.UtilisateurReposetory;
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
import java.util.HashMap;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/artisan")

public class ArtisanController {
@Autowired
   private ArtisanReposetory artisanReposetory;
    @Autowired
    private CompteServices compteServices ;
@Autowired
private RolesReposetory rolesReposetory;
@Autowired
private UtilisateurReposetory utilisateurReposetory;
@Autowired
private EmplacementReposetory emplacementReposetory;

    private final Path rootLocation = Paths.get("images");

    @GetMapping("/all")
    List<Artisan> getAll() {
        return artisanReposetory.findAll();
    }

   /* @PostMapping("/addartisan")
    Artisan Ajouter(@RequestBody Artisan artisan) {
        return artisanReposetory.save(artisan);
    }*/
   @PostMapping("/addartisan")
   public Artisan regitrer (@RequestBody Artisan artisan){

       Artisan artisan1= (Artisan) compteServices.FindUserByUsername(artisan.getUsername());
       if(artisan1!=null)throw new RuntimeException("username exist");



       Artisan artisan2=new Artisan();
       artisan2.setUsername(artisan.getUsername());
       artisan2.setPassword(artisan.getPassword());
       artisan2.setPrenom(artisan.getPrenom());
       artisan2.setEmail(artisan.getEmail());

       Roles role =rolesReposetory.findByRoleNom("ARTISAN");
       artisan2.getRoles().add(role);

       return (Artisan) compteServices.saveUser(artisan2);
   }
    @PostMapping("/save")
    public Artisan ajouter(/*@RequestParam("file")MultipartFile file,*/ @RequestParam("longitude") String longitude,@RequestParam("latitude") String latitude,@RequestParam("artisan1") String artisan,@RequestParam("Biblieographie")String bibileographie,@RequestParam("Compétances")String Compétances,@RequestParam("Education")String Education) throws IOException,JsonParseException,JsonMappingException
    {
        ObjectMapper objectMapper = new ObjectMapper();

     /*   objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);*/

        Artisan a = objectMapper.readValue(artisan, Artisan.class);

System.out.println(a.getDateinscription());
        System.out.println(rootLocation.toString());
        boolean isExist = new File(rootLocation.toString()).exists();
System.out.println(longitude);
        if (!isExist) {
            Files.createDirectory(rootLocation);
            System.out.println("mk Dir");
            }

/*            String filename = file.getOriginalFilename();
            String newfilename = FilenameUtils.getBaseName(filename) + "." + FilenameUtils.getExtension(filename);

        Files.copy(file.getInputStream(), this.rootLocation.resolve(newfilename));*/

        Artisan artisan1= (Artisan) compteServices.FindUserByUsername(a.getUsername());
        if(artisan1!=null)throw new RuntimeException("username exist");


        Artisan artisan2=new Artisan();
        Emplacement emp=new Emplacement();
        emp.setAltetude(latitude);
        emp.setLongetude(longitude);
        emp.setNomville(a.getVille());
        emplacementReposetory.save(emp);


        artisan2.setUsername(a.getUsername());
        artisan2.setPassword(a.getPassword());
        artisan2.setPrenom(a.getPrenom());
        artisan2.setEmail(a.getEmail());
        artisan2.setVille(a.getVille());
artisan2.setDateinscription(a.getDateinscription());
artisan2.setTel(a.getTel());
artisan2.setEducation(Education);
artisan2.setBiblieographie(bibileographie);
artisan2.setCompetances(Compétances);
        Roles role =rolesReposetory.findByRoleNom("ARTISAN");
        artisan2.getRoles().add(role);


       artisan2.setPhotodeprofil("user.png");
        /*System.out.println(newfilename);*/

        artisan2.setEmplacementid(emp);

      //  if(a != null) {
            return(Artisan) compteServices.saveUser(artisan2);

    //    }
      //  else{
        //    return new ResponseEntity<Response>(new Response(" not saved"), HttpStatus.BAD_REQUEST);

        }


    @PutMapping("/update")
    public Artisan update(@RequestParam("file")MultipartFile file ,@RequestParam("id") Long id)  throws IOException,JsonParseException,JsonMappingException{
         Artisan a = artisanReposetory.findbyId(id);
        System.out.println(a);
            String filename = file.getOriginalFilename();
            String newfilename = FilenameUtils.getBaseName(filename) + "." + FilenameUtils.getExtension(filename);

        Files.copy(file.getInputStream(), this.rootLocation.resolve(newfilename));
System.out.println(id);

        a.setPhotodeprofil(newfilename);
        return artisanReposetory.saveAndFlush(a);
    }

    @DeleteMapping("/delete/{Id}")
    public HashMap<String, String> delete(@PathVariable Long Id) {
        HashMap hashmap = new HashMap();
        try {
            artisanReposetory.deleteById(Id);
            hashmap.put("etat", "suprimer");

        } catch (Exception e) {
            hashmap.put("etat", " non  suprimer");
        }
        return hashmap;

    }
    @GetMapping("/getone/{id}")
    Artisan findbyId(@PathVariable Long id){
        return artisanReposetory.getOne(id);
    }
    @GetMapping("/imgArticle/{id}")
    public byte[]getPhoto(@PathVariable("id")Long id) throws Exception{
       Utilisateur utilisateur=utilisateurReposetory.findbyId(id);
       return Files.readAllBytes(Paths.get(rootLocation +"/"+utilisateur.getPhotodeprofil()));
    }
   /* @GetMapping("/findbymc")
    List<Artisan> ChercherParMc(String mc){
        return artisanReposetory.chercher1("%"+mc+"%");
    }*/

    @GetMapping("/desc")
    List<Artisan> desc(){
        return artisanReposetory.alldesc();
    }
    @DeleteMapping("/delete")
    public HashMap<String, String> deleteall() {
        HashMap hashmap = new HashMap();
        try {
            artisanReposetory.deleteAll();
            hashmap.put("etat", "suprimer");

        } catch (Exception e) {
            hashmap.put("etat", " non  suprimer");
        }
        return hashmap;

    }
    @GetMapping("/artisandmm/{date}")
    List<Artisan> cmdmm(@PathVariable String date){
        return artisanReposetory.artisanderniermm(date);
    }
}
