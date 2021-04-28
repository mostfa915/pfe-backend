package com.pfe.demo.entiter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Artisan extends Utilisateur {

    @OneToMany(mappedBy = "idArtisan",fetch = FetchType.LAZY)
    private Collection<Produit> ProduitArtisan;
    @OneToMany(mappedBy = "idArtisan")
    private Collection<Calendriers> EvennementduArtisan;



    public Artisan(String username,String prenom, String email, String password) {
        super(username,prenom,email, password);
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
