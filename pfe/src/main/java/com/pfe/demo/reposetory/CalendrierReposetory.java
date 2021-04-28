package com.pfe.demo.reposetory;

import com.pfe.demo.entiter.Calendriers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendrierReposetory extends JpaRepository<Calendriers,Long> {
}
