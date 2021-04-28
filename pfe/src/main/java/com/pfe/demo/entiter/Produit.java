package com.pfe.demo.entiter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Produit {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
    private String nom;

   private String description;
private double prix ;
private static int qte= 1;
    private String FileName;
  private Long Idd;

    public Long getIdd() {
        return Idd;
    }

    public void setIdd(Long idd) {
        Idd = idd;
    }

    public Artisan getIdArtisan() {
        return idArtisan;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String fileName) {
        FileName = fileName;
    }

    public Categories getCategorieProduit() {
        return CategorieProduit;
    }

    public void setCategorieProduit(Categories categorieProduit) {
        CategorieProduit = categorieProduit;
    }
@JsonIgnore
    public Collection<Pannier> getPannierProduit() {
        return PannierProduit;
    }

    public void setPannierProduit(Collection<Pannier> pannierProduit) {
        PannierProduit = pannierProduit;
    }

    public Collection<ProduitEvennement> getProduitEvent() {
        return ProduitEvent;
    }

    public void setProduitEvent(Collection<ProduitEvennement> produitEvent) {
        ProduitEvent = produitEvent;
    }

    @ManyToOne
    @JoinColumn(name ="CategorieProd")
    private Categories CategorieProduit ;
    @OneToMany(mappedBy ="Idproduit")
    private Collection<Pannier> PannierProduit ;
    @OneToMany(mappedBy = "idproduit")
    private Collection<Commentaire> Commentaires;
@JsonIgnore
    public Collection<Commentaire> getCommentaires() {
        return Commentaires;
    }

    public void setCommentaires(Collection<Commentaire> commentaires) {
        Commentaires = commentaires;
    }

    @ManyToOne
@JoinColumn(name = "idArtisan")
    private Artisan idArtisan ;

    public Artisan getIdArtisan(Produit produit) {
        return idArtisan;
    }

    public Produit(String nom, String description, double prix, Categories categorieProduit, Collection<Pannier> pannierProduit, Artisan idArtisan, Collection<ProduitEvennement> produitEvent) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        CategorieProduit = categorieProduit;
        PannierProduit = pannierProduit;
        this.idArtisan = idArtisan;
        ProduitEvent = produitEvent;
    }

    public void setIdArtisan(Artisan idArtisan) {
        this.idArtisan = idArtisan;
    }

    @OneToMany(mappedBy ="idProduit")
  private Collection<ProduitEvennement>ProduitEvent ;

    public Categories getCategorieproduit() {
        return CategorieProduit;
    }

    public void setCategorieproduit(Categories CategorieProduit) {
        this.CategorieProduit = CategorieProduit;
    }

    public Long getId() {
        return id;
    }




    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Produit( String description, double prix) {

        this.description = description;
        this.prix = prix;
    }

    public Produit() {
    }

    public Produit(String nom, String description, double prix, String fileName, Categories categorieProduit, Collection<Pannier> pannierProduit, Collection<Commentaire> commentaires, Artisan idArtisan, Collection<ProduitEvennement> produitEvent) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        FileName = fileName;
        CategorieProduit = categorieProduit;
        PannierProduit = pannierProduit;
        Commentaires = commentaires;
        this.idArtisan = idArtisan;
        ProduitEvent = produitEvent;
    }
}
