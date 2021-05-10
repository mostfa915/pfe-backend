package com.pfe.demo.entiter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Inheritance(strategy =InheritanceType.JOINED)
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @Column(unique=true)
    private String username ;
    private String photodeprofil;
private String adresse;
private String ville;
private String codepostale;
    private String prenom;
    private String email ;
    private String password;
    private String tel;
    private String dateinscription;
    @OneToOne
    @JoinColumn(name = "emplacementid")
    private Emplacement emplacementid;
   @ManyToMany(fetch=FetchType.EAGER)
    private Collection<Roles> roles=new ArrayList<>();
    @OneToMany(mappedBy = "idUtilisateur",fetch =FetchType.LAZY)
    private Collection<Message> Messages;
    @OneToMany(mappedBy = "idDestinataire",fetch =FetchType.LAZY)
    private Collection<Message> Messages2;
    @OneToMany(mappedBy = "IdUtilisateur",fetch = FetchType.LAZY)
    private Collection<Commentaire> Commentaires;
@JsonIgnore
    public Collection<Message> getMessages() {
        return Messages;
    }
@JsonIgnore
    public Collection<Message> getMessages2() {
        return Messages2;
    }

    public void setMessages2(Collection<Message> messages2) {
        Messages2 = messages2;
    }

    public String getDateinscription() {
        return dateinscription;
    }

    public void setDateinscription(String dateinscription) {
        this.dateinscription = dateinscription;
    }

    @JsonIgnore
    public Collection<Commentaire> getCommentaires() {
        return Commentaires;
    }

    public void setCommentaires(Collection<Commentaire> commentaires) {
        Commentaires = commentaires;
    }

    public void setMessages(Collection<Message> messages) {
        Messages = messages;
    }

    public Emplacement getEmplacementid() {
        return emplacementid;
    }

    public void setEmplacementid(Emplacement emplacementid) {
        this.emplacementid = emplacementid;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodepostale() {
        return codepostale;
    }

    public void setCodepostale(String codepostale) {
        this.codepostale = codepostale;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Collection<Roles> getRoles() {
        return roles;
    }

    public Utilisateur(String nom, String prenom, String email, String motdepasse, Collection<Roles> roles) {
        this.username = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = motdepasse;
        this.roles = roles;
    }

    public Utilisateur(String username, String motdepasse, Collection<Roles>roles) {
        this.username = username;
        this.password = motdepasse;
        this.roles = roles;
    }

    public String getPhotodeprofil() {
        return photodeprofil;
    }

    public void setPhotodeprofil(String photodeprofil) {
        this.photodeprofil = photodeprofil;
    }

    public void setRoles(Collection<Roles> roles) {
        this.roles = roles;
    }

    public Utilisateur() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Utilisateur(String username,String prenom, String email, String password) {
        this.username = username;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
    }
}

