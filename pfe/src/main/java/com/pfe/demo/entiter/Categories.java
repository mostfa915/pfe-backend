package com.pfe.demo.entiter;

import javax.persistence.*;
import java.util.Collection;

@Entity

public class Categories {
@Id     @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long Id ;
private String  nom ;

    @OneToMany(mappedBy="CategorieProduit")
    private Collection<Produit> produitParCategorie;

    public Long getId() {
        return Id;
    }

   public Categories( String nom, Collection<Produit> produitParCategorie) {

        this.nom = nom;
        this.produitParCategorie= produitParCategorie;
    }
    public Categories(String nom) {

        this.nom = nom;

    }

    public Categories() {



    }
    public void setId(Long id) {
        Id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Collection<Produit> getProducts() {
        return produitParCategorie;
    }

    public void setProducts(Collection<Produit> produitParCategorie) {
        this.produitParCategorie = produitParCategorie;
    }
}
