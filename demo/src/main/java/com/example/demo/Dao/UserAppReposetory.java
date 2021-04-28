package com.example.demo.Dao;

import com.example.demo.Entiter.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAppReposetory extends JpaRepository<UserApp,Long> {
public UserApp findByUsername(String username);
}
