package com.pfe.demo.reposetory;

import com.pfe.demo.entiter.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommandeReposetory extends JpaRepository<Commande,Long> {
    @Query("select p from Commande p where p.id like :x")

    Commande findbyId( @Param("x") Long id);


    @Query("select p from Commande p where p.id like :x")
    Commande findbycode( @ Param("x") Long id);
    @Query("select count(e) from Commande e")
    Long countallCommande();
    @Query("select  p from Commande p order by p.id desc")
    List<Commande>alldesc();
    @Query("select  p from Commande p where p.datecommande like  "+'%'+":x"+'%')

    List<Commande> commandederniermm(@Param("x") String date);
    @Query("select  p from Commande p where p.datecommande like  "+'%'+":x"+'%')

    List<Commande> commandederniermm2(@Param("x") String date);
    @Query("select  p from Commande p where p.IdClient.id like :x ")
    List<Commande>commandeclient( @ Param("x") Long id);
}


