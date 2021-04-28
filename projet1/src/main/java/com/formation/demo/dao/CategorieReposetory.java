package com.formation.demo.dao;

import com.formation.demo.entites.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieReposetory extends JpaRepository<Categorie,Long> {
}
