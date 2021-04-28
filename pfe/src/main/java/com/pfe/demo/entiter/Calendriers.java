package com.pfe.demo.entiter;

import javax.persistence.*;

@Entity
public class Calendriers {
@Id
@GeneratedValue(strategy = GenerationType.TABLE)

    private Long id ;

@ManyToOne
    @JoinColumn(name = "idArtisan")
    private Artisan idArtisan ;


    @ManyToOne
    @JoinColumn(name = "iEvennement")
    private Evennement idEvennement ;

}
