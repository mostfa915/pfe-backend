package com.pfe.demo.entiter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;


@Entity
public class ProduitEvennement {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

private Long id ;


  @ManyToOne
    @JoinColumn(name ="idEvennement")
    private Evennement IdEvennement ;
    @ManyToOne
    @JoinColumn(name ="idProduit")
    private Produit idProduit ;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Evennement getIdEvennement() {
    return IdEvennement;
  }

  public void setIdEvennement(Evennement idEvennement) {
    IdEvennement = idEvennement;
  }
@JsonIgnore
  public Produit getIdProduit() {
    return idProduit;
  }

  public void setIdProduit(Produit idProduit) {
    this.idProduit = idProduit;
  }
}
