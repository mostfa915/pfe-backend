package com.example.demo.Dao;

import com.example.demo.Model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudaintReposetory extends JpaRepository<Etudiant,Long> {
}
