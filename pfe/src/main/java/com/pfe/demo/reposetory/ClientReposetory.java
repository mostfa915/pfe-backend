package com.pfe.demo.reposetory;

import com.pfe.demo.entiter.Clients;
import com.pfe.demo.entiter.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientReposetory extends JpaRepository<Clients,Long> {
    @Query("select p from Utilisateur p where p.username like :x")
  Utilisateur findbyname(@Param("x") String mc);

}
