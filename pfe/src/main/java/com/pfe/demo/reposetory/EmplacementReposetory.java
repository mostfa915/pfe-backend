package com.pfe.demo.reposetory;

import com.pfe.demo.entiter.Emplacement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmplacementReposetory extends JpaRepository<Emplacement,Long> {
   /* @Query("select c  from Commande  p where p.id like :x and   ")
    List<Commentaire> findcommentairesbyidProduit(@Param("x") Long id);*/
}
