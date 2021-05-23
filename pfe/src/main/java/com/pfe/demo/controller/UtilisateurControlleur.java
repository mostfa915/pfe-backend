package com.pfe.demo.controller;

import com.pfe.demo.Services.CompteServices;
import com.pfe.demo.Services.UserdetailServiceImplimentation;
import com.pfe.demo.entiter.Produit;
import com.pfe.demo.entiter.Roles;
import com.pfe.demo.entiter.Utilisateur;
import com.pfe.demo.reposetory.RolesReposetory;
import com.pfe.demo.reposetory.UtilisateurReposetory;
import com.pfe.demo.securité.Authentificationresponse;
import com.pfe.demo.securité.SecuriteConstraintes;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/utilisateur")
public class UtilisateurControlleur {
    private final Path rootLocation = Paths.get("images");
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
     UserdetailServiceImplimentation userdetailServiceImplimentation;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    CompteServices compteServices;
    @Autowired
    RolesReposetory rolesReposetory;
    @Autowired
    UtilisateurReposetory utilisateurReposetory;
   @GetMapping("/all")
    List<Utilisateur>getall(){
       return utilisateurReposetory.findAll();
   }
    @PostMapping("/addutilisateur")
    public Utilisateur regitrer (@RequestBody Utilisateur utilisateur){

        Utilisateur utilisateur1=  compteServices.FindUserByUsername(utilisateur.getUsername());
        if(utilisateur!=null)throw new RuntimeException("username exist");



        Utilisateur utilisateur2=new Utilisateur();
        utilisateur2.setUsername(utilisateur.getUsername());
        utilisateur2.setPassword(utilisateur.getPassword());
        utilisateur2.setPrenom(utilisateur.getPrenom());
        utilisateur2.setEmail(utilisateur.getEmail());

        Roles role =rolesReposetory.findByRoleNom("ADMIN");
        utilisateur2.getRoles().add(role);
        Roles role2 =rolesReposetory.findByRoleNom("USER");
        utilisateur2.getRoles().add(role2);
        return  compteServices.saveUser(utilisateur2);
    }
    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody Utilisateur utilisateur)

     throws  IOException {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(utilisateur.getUsername(),utilisateur.getPassword()));

        // Inject into security context

        UserDetails user = userdetailServiceImplimentation.loadUserByUsername(utilisateur.getUsername());
        User springUser = (User) user;
        String jwt = Jwts.builder()
                .setSubject(springUser.getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + SecuriteConstraintes.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SecuriteConstraintes.SECRET)
                .claim("roles", springUser.getAuthorities())
                .compact();
        System.out.println("9**");
        System.out.println(jwt);

Utilisateur u =utilisateurReposetory.findByUsername(springUser.getUsername());
        return ResponseEntity.ok(new Authentificationresponse(SecuriteConstraintes.TOKEN_PREFIX+jwt,u));
    }

    @GetMapping("/getone/{id}")
    Utilisateur findbyId(@PathVariable Long id){
        return utilisateurReposetory.getOne(id);
    }

    @GetMapping("/imgArticle/{username}")
    public byte[]getPhoto(@PathVariable String username) throws Exception{
        Utilisateur utilisateur=utilisateurReposetory.findbyn(username);
        System.out.println("user"+utilisateur);

        return Files.readAllBytes(Paths.get(rootLocation +"/"+utilisateur.getPhotodeprofil()));
    }
    @GetMapping("/count")
    Long counts(){
        return utilisateurReposetory.countallusers();
    }
    @GetMapping("/findbyname/{username}")
    Utilisateur getuserbyname(@PathVariable String username){
        return utilisateurReposetory.findByUsername(username);
    }
    @GetMapping("/img")
    public byte[]getPhoto2() throws Exception{

        return Files.readAllBytes(Paths.get(rootLocation +"/"+"favicon.ico.png"));
    }
    @GetMapping("/imgArticle2/{id}")
    public byte[]getPhoto(@PathVariable("id")Long id) throws Exception{
        Utilisateur utilisateur=utilisateurReposetory.findbyId(id);




        //return Files.readAllBytes(Paths.get(context.getRealPath("/images/") + product.getFileName()));
        return Files.readAllBytes(Paths.get(rootLocation +"/"+ utilisateur.getPhotodeprofil()));
    }
    @GetMapping("/utilisateurparemail/{email}")
    public Utilisateur getUserbyemail(@PathVariable("email")String email) {
        return utilisateurReposetory.findbyemail(email);  }
    @PutMapping("/updatepwd/{email}/{password}")
    public Utilisateur updatepwd(@PathVariable("email")String email,@PathVariable("password")String password) {

            Utilisateur utilisateur=utilisateurReposetory.findbyemail(email);
      System.out.println(utilisateur);
        String hashPassword =bCryptPasswordEncoder.encode(password);
     /* bCryptPasswordEncoder.upgradeEncoding()*/
        utilisateur.setPassword(hashPassword);


        return utilisateurReposetory.saveAndFlush(utilisateur);  }
}

