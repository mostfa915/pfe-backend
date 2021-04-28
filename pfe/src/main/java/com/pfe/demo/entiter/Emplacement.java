package com.pfe.demo.entiter;

import javax.persistence.*;

@Entity
public class Emplacement {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id ;
private String nomville;
private String altetude ;
private String longetude ;

    public String getNomville() {
        return nomville;
    }

    public void setNomville(String nomville) {
        this.nomville = nomville;
    }

    @OneToOne(mappedBy ="emplacementid")



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAltetude() {
        return altetude;
    }

    public void setAltetude(String altetude) {
        this.altetude = altetude;
    }

    public String getLongetude() {
        return longetude;
    }

    public void setLongetude(String longetude) {
        this.longetude = longetude;
    }
}
