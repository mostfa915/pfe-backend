package com.formation.demo.dao;

import com.formation.demo.entites.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderReposetory extends JpaRepository<Provider,Long> {
}
