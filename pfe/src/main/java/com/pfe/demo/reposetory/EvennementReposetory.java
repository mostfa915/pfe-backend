package com.pfe.demo.reposetory;

import com.pfe.demo.entiter.Evennement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EvennementReposetory extends JpaRepository<Evennement,Long> {
    @Query("select p from Evennement p where p.id like :x")
    Evennement findbyId(@Param("x") Long id);
}
