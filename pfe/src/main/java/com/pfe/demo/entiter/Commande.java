package com.pfe.demo.entiter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
public class Commande {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
private String nom ;
private String datecommande;
private String adresse;
private String ville;
private String codepostale ;
private String tel ;
private String code_commande;
    private String adressedelivraison ;
    public String getAdressedelivraison() {
        return adressedelivraison;
    }

    public void setAdressedelivraison(String adressedelivraison) {
        this.adressedelivraison = adressedelivraison;
    }


    public String getCode_commande() {
        return code_commande;
    }

    public void setCode_commande(String code_commande) {
        this.code_commande = code_commande;
    }

    public void setLpanniers(Collection<Pannier> lpanniers) {
        this.lpanniers = lpanniers;
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

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
    public Clients getIdClient() {
        return IdClient;
    }

    public void setIdClient(Clients idClient) {
        IdClient = idClient;
    }





    private double montant;
//private Pannier


@ManyToOne
@JoinColumn(name ="IdCilent")
private Clients IdClient;




   @OneToMany(mappedBy="IdCommande" )

   private   Collection<Pannier>lpanniers;


@JsonIgnore
    public Collection<Pannier> getLpanniers() {
        return lpanniers;
    }

    public void setLpaniers(Collection<Pannier> lpanniers) {
        this.lpanniers = lpanniers;
    }

    public String getDatecommande() {
        return datecommande;
    }

    public void setDatecommande(String datecommande) {
        this.datecommande = datecommande;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Commande(String nom, Date datecommande, String adresse, String ville, String codepostale, String tel, double montant, Clients idClient, Collection<Pannier> lpanniers) {
        this.nom = nom;
        this.adresse = adresse;
        this.ville = ville;
        this.codepostale = codepostale;
        this.tel = tel;
        this.montant = montant;
        IdClient = idClient;
        this.lpanniers = lpanniers;
    }

    public Commande() {
    }
}
