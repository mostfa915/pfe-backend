package com.pfe.demo.entiter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Fournisseur extends Utilisateur {
    @OneToMany(mappedBy="idFournisseur")
    private Collection<Pannier>FournisseurPannier;

    public Fournisseur(String nom, String motdepasse, Collection<Roles> roles) {
        super(nom, motdepasse, roles);
    }

    public Fournisseur(String nom,String prenom, String email, String motdepasse) {
        super(nom,prenom,email, motdepasse);
    }

    public Fournisseur() {
    }
}
