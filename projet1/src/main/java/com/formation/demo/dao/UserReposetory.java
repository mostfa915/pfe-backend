package com.formation.demo.dao;

import com.formation.demo.entites.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReposetory extends JpaRepository<Users,Long>{
}
