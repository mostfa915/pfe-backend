package com.pfe.demo.reposetory;

import com.pfe.demo.entiter.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProduitReposetory extends JpaRepository<Produit,Long> {
    @Query("select p from Produit p where p.nom like :x")
    List<Produit> chercher(@Param("x") String mc);

    @Query("select p from Produit p where p.id like :x")
    Produit findbyId( @ Param("x") Long id);

    @Query("select p from Produit p where p.idArtisan.id like :x ")
   List<Produit> findProductbyartisa( @ Param("x") Long id);
    @Query("select count(e) from Produit e")
    Long countallproduits();
    @Query("select  p from Produit p order by p.id desc")
    List<Produit>alldesc();
}

