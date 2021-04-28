package com.pfe.demo.entiter;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Evennement {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id ;
private String nom ;
private String place ;

@OneToMany(mappedBy = "idEvennement")
    private Collection<Calendriers> calendriersEvennements ;
    @OneToMany(mappedBy = "IdEvennement")
    private Collection<ProduitEvennement> ProduitEvennements;


    public Evennement(String nom, String place, Collection<Calendriers> calendriersEvennements, Collection<ProduitEvennement> produitEvennements) {
        this.nom = nom;
        this.place = place;
        this.calendriersEvennements = calendriersEvennements;
        ProduitEvennements = produitEvennements;
    }

    public Evennement() {
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Collection<Calendriers> getCalendriersEvennements() {
        return calendriersEvennements;
    }

    public void setCalendriersEvennements(Collection<Calendriers> calendriersEvennements) {
        this.calendriersEvennements = calendriersEvennements;
    }

    public Collection<ProduitEvennement> getProduitEvennements() {
        return ProduitEvennements;
    }

    public void setProduitEvennements(Collection<ProduitEvennement> produitEvennements) {
        ProduitEvennements = produitEvennements;
    }
}
