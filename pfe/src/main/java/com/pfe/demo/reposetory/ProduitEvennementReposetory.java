package com.pfe.demo.reposetory;

import com.pfe.demo.entiter.Commande;
import com.pfe.demo.entiter.ProduitEvennement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProduitEvennementReposetory extends JpaRepository<ProduitEvennement,Long> {
    @Query("select p from ProduitEvennement p where p.id like :x")
    ProduitEvennement findbyId(@Param("x") Long id);
}
