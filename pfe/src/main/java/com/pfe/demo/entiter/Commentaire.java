package com.pfe.demo.entiter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
    @Entity
    public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name ="IdUtilisateur")
    private Utilisateur IdUtilisateur;
    @ManyToOne
    @JoinColumn(name ="idProduit")
    private Produit idproduit;
    private Long idProd;
    private String commentaire;
    private String nomclient;
    private String datecommentaitre ;

        public String getDatecommentaitre() {
            return datecommentaitre;
        }

        public void setDatecommentaitre(String datecommentaitre) {
            this.datecommentaitre = datecommentaitre;
        }

        public Utilisateur getIdUtilisateur() {
        return IdUtilisateur;
    }

    public void setIdUtilisateur(Utilisateur idUtilisateur) {
        IdUtilisateur = idUtilisateur;
    }

    public String getNomclient() {
        return nomclient;
    }

    public void setNomclient(String nomclient) {
        this.nomclient = nomclient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonIgnore
    public Produit getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(Produit idproduit) {
        this.idproduit = idproduit;
    }


    public Long getIdProd() {
        return idProd;
    }

    public void setIdProd(Long idProd) {
        this.idProd = idProd;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Commentaire() {
    }

}
