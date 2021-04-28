package com.formation.demo.dao;

import com.formation.demo.entites.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientReposetory extends JpaRepository<Client,Long> {
}
