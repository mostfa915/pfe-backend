package com.formation.demo.dao;

import com.formation.demo.entites.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminReposetory extends JpaRepository<Admin,Long> {
}
