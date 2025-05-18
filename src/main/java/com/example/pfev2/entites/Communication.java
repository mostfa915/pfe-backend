package com.example.pfev2.entites;

// model/Communication.java


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class Communication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    public Communication( String sms) {
   this.content = sms;
    }

    public Communication() {

    }

    // Méthode pour envoyer une notification
    public void envoyerNotification() {
        // Implémentation de l'envoi de notification
    }
}