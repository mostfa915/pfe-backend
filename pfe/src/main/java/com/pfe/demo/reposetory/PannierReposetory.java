package com.pfe.demo.reposetory;

import com.pfe.demo.entiter.Clients;
import com.pfe.demo.entiter.Pannier;
import com.pfe.demo.entiter.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PannierReposetory  extends JpaRepository<Pannier,Long> {
    @Query("select count(p) from Pannier p where p.Idproduit.idArtisan.id like :x")
    Long countclientpourartisan(@Param ("x")Long id);
    @Query("select p from Pannier p where p.Idproduit.idArtisan.id like :x")
    List<Pannier> clientartisan(@Param ("x")Long id);
    @Query("select distinct c from Utilisateur c,Pannier p  where p.Idproduit.idArtisan.id  like :x")
    List <Utilisateur> clientpourartisan(@Param ("x")Long id);

    @Query("select  p from Pannier p where  p.Idproduit.idArtisan.id like :x1 and  p.datepannier like "+'%'+":x"+'%')
    List<Pannier> commandedernierm(@Param("x")String date ,@Param("x1") Long id);
    @Query("select  p from Pannier p order by p.id desc")
    List<Pannier>alldesc();
    @Query("select p from Pannier p where p.IdCommande.id like :x")
    List <Pannier> pannierducommande(@Param ("x")Long id);
    @Query("select p from Pannier p where p.id1 like :x")
    Pannier pannierbyid(@Param ("x")Long id);
}
