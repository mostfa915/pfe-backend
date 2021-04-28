package com.pfe.demo.reposetory;

import com.pfe.demo.entiter.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminReposetory extends JpaRepository<Admin,Long> {
}
