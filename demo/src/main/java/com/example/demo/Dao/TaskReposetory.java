package com.example.demo.Dao;

import com.example.demo.Entiter.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskReposetory extends JpaRepository<Task,Long> {
}
