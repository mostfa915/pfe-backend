package com.pfe.demo.entiter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Pannier implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id1;
private String nom ;
    public double prix;
    public String etat="En attente";

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Long getId1() {
        return id1;
    }

    public void setId1(Long id1) {
        this.id1 = id1;
    }

    public Fournisseur getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(Fournisseur idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    @ManyToOne
    @JoinColumn(name = "idFournisseur")
private Fournisseur idFournisseur;
   @ManyToOne
    @JoinColumn(name ="IdProduit")
    private Produit Idproduit;
    @ManyToOne
    private Commande IdCommande;
    String datepannier;
    private Long qte;

    public Long getQte() {
        return qte;
    }

    public void setQte(Long qte) {
        this.qte = qte;
    }

    public String getDatepannier() {
        return datepannier;
    }

    public void setDatepannier(String datepannier) {
        this.datepannier = datepannier;
    }


    public Commande getIdCommande() {

        return IdCommande;
    }

    public void setIdCommande(Commande idCommande) {
        IdCommande = idCommande;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public Produit getIdproduit() {
        return Idproduit;
    }
private  long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setIdproduit(Produit idproduit) {
        Idproduit = idproduit;
    }



    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }



    public Pannier(String nom, double prix, Fournisseur idFournisseur, Produit idproduit, Commande idCommande ) {
        this.nom = nom;
        this.prix = prix;
        this.idFournisseur = idFournisseur;
        Idproduit = idproduit;
        IdCommande = idCommande;

    }

    public Pannier() {
    }
}
