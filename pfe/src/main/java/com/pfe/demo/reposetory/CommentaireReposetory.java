package com.pfe.demo.reposetory;

import com.pfe.demo.entiter.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentaireReposetory extends JpaRepository<Commentaire,Long> {
    @Query("select p from Commentaire p where p.idproduit.id like :x  ")
    List<Commentaire> findcommentairesbyidProduit(@Param("x") Long id);
    @Query("select count(e) from Commentaire e")
    Long countallcomment();
}
