package com.example.demo.Dao;

import com.example.demo.Entiter.RoleApp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleAppReposetory extends JpaRepository<RoleApp,Long> {
public RoleApp findByRoleName(String rolename);
}
