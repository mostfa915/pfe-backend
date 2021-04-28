package com.pfe.demo.reposetory;

import com.pfe.demo.entiter.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UtilisateurReposetory extends JpaRepository<Utilisateur,Long> {
    public Utilisateur findByUsername(String username);
    @Query("select p from Utilisateur p where p.id like :x")
   Utilisateur findbyId( @Param("x") Long id);
    @Query("select p from Utilisateur p where p.username like :x")
    Utilisateur findbyn( @Param("x") String username);

    @Query("select p from Utilisateur p where p.email like :x")
    Utilisateur findbyemail( @Param("x") String email);

    @Query("select count(e) from Utilisateur e")
    Long countallusers();
    @Query("select p from Utilisateur p where p.username like :x")
    Utilisateur findbyname(@Param("x") String mc);

   /* @Query("update Utilisateur s set s.password=:x where s.email=:x1")
    Utilisateur updatepwd(@Param("x1") String email,@Param("x") String pwd);*/



}
