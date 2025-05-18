package com.example.pfev2.entites;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String num ;
    private String email ;
    private String mdpHash ;
    @Enumerated(EnumType.STRING)
    private Role role ;

public Utilisateur() {}
    public Utilisateur(String num, String email, String mdpHash, Role role) {}




    public enum Role {
        COPROPRIETAIRE , SYNDIC , PRESTATAIRE
    }
}