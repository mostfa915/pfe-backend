package com.pfe.demo.entiter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Clients  extends Utilisateur {

   @OneToMany(mappedBy="IdClient")
    private Collection<Commande> ClientCommandes;


    public Collection<Commande> getClientCommandes() {
        return ClientCommandes;
    }

    public void setClientCommandes(Collection<Commande> clientCommandes) {
        ClientCommandes = clientCommandes;
    }

    public Clients(String nom, String prenom, String email, String motdepasse , Collection<Roles> roles) {
        super(nom,prenom,email, motdepasse,roles);
    }
    public Clients(){

    }
}
