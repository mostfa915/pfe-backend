package com.pfe.demo.entiter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
private  String Message;
private String date;
private int vu;


    @ManyToOne
    @JoinColumn(name ="idDiscussion")
    private Discussion idDiscussion;
    @JoinColumn(name ="idUtilisateur")
    @ManyToOne
    private Utilisateur idUtilisateur;
    @ManyToOne
    private Utilisateur idDestinataire;

    public int getVu() {
        return vu;
    }

    public void setVu(int vu) {
        this.vu = vu;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Utilisateur getIdDestinataire() {
        return idDestinataire;
    }

    public void setIdDestinataire(Utilisateur idDestinataire) {
        this.idDestinataire = idDestinataire;
    }

    @JsonIgnore
    public Discussion getIdDiscussion() {
        return idDiscussion;
    }

    public Utilisateur getIdUtilisateur() {
        return idUtilisateur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public Discussion getIdDiscussion(Discussion discussion) {
        return idDiscussion;
    }

    public void setIdDiscussion(Discussion idDiscussion) {
        this.idDiscussion = idDiscussion;
    }

    public Utilisateur getIdUtilisateur(Utilisateur byUsername) {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Utilisateur idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Message() {
    }
}
