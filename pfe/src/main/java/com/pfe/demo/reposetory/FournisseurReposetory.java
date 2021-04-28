package com.pfe.demo.reposetory;

import com.pfe.demo.entiter.Artisan;
import com.pfe.demo.entiter.Commande;
import com.pfe.demo.entiter.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FournisseurReposetory extends JpaRepository<Fournisseur,Long> {
    @Query("select p from Fournisseur p where p.username like :x")
    List<Fournisseur> chercher1(@Param("x") String mc);


    @Query("select p from Fournisseur p where p.id like :x")
    Fournisseur findbyId(@Param("x") Long id);
}
