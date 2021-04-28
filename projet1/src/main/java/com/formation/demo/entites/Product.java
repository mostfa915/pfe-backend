package com.formation.demo.entites;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="produit")
public class Product implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private  String name;
    private Double  price;
    private String description ;
     @ManyToOne
     @JoinColumn(name ="idcatprod")
      private SousCategorie catprod ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product() {
    }

    public SousCategorie getCatprod() {
        return catprod;
    }

    public void setCatprod(SousCategorie catprod) {
        this.catprod = catprod;
    }
}
