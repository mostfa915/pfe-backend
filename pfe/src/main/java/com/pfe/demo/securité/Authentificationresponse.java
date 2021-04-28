package com.pfe.demo.securité;

import com.pfe.demo.entiter.Utilisateur;
import org.springframework.security.core.userdetails.UserDetails;

public class Authentificationresponse {
String jwt;
private Utilisateur utilisateur;


    public Authentificationresponse(String jwt,Utilisateur utilisateur) {
        this.jwt = jwt;
        this.utilisateur=utilisateur;
    }

    public String getJwt() {
        return jwt;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }
}
