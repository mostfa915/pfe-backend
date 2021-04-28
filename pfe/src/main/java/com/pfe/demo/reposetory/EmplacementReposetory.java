package com.pfe.demo.reposetory;

import com.pfe.demo.entiter.Emplacement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmplacementReposetory extends JpaRepository<Emplacement,Long> {
}
