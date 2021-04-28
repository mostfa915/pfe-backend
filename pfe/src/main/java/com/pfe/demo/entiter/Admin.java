package com.pfe.demo.entiter;

import javax.persistence.Entity;
import java.util.Collection;

@Entity
public class Admin extends Utilisateur {


    public Admin(String nom, String prenom, String email, String motdepasse, Collection<Roles> roles) {
        super(nom, prenom, email, motdepasse, roles);
    }

    public Admin() {
    }
}
