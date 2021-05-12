package com.pfe.demo.entiter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Artisan extends Utilisateur {
        private String Biblieographie;
      private String Competances;
            private String  Education;

    @OneToMany(mappedBy = "idArtisan",fetch = FetchType.LAZY)
    private Collection<Produit> ProduitArtisan;
    @OneToMany(mappedBy = "idArtisan")
    private Collection<Calendriers> EvennementduArtisan;

    public String getBiblieographie() {
        return Biblieographie;
    }
    public void setBiblieographie(String biblieographie) {
        Biblieographie = biblieographie;
    }

    public String getCompetances() {
        return Competances;
    }

    public void setCompetances(String compétances) {
        Competances = compétances;
    }

    public String getEducation() {
        return Education;
    }

    public void setEducation(String education) {
        Education = education;
    }

    public Artisan(String username, String prenom, String email, String password,String Biblieographie,String education,String compétances) {
        super(username,prenom,email, password);
        this.Education=education;
        /*this.Biblieographie=Biblieographie;*/
        this.Competances=compétances;
    }

    public Artisan() {
    }

    public Artisan(String username, String prenom, String email, String password, Collection<Roles> roles, Collection<Calendriers> evennementduArtisan , Collection<Produit> produitArtisan) {
        super(username, prenom, email, password, roles);
        EvennementduArtisan = evennementduArtisan;
        ProduitArtisan=produitArtisan;
    }





    @JsonIgnore
    public Collection<Produit> getProduitArtisan() {
        return ProduitArtisan;
    }

    public void setProduitArtisan(Collection<Produit> produitArtisan) {
        ProduitArtisan = produitArtisan;
    }

    public Collection<Calendriers> getEvennementduArtisan() {
        return EvennementduArtisan;
    }

    public void setEvennementduArtisan(Collection<Calendriers> evennementduArtisan) {
        EvennementduArtisan = evennementduArtisan;
    }


}
