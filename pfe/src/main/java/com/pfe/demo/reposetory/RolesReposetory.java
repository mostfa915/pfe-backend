package com.pfe.demo.reposetory;

import com.pfe.demo.entiter.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesReposetory extends JpaRepository<Roles,Long> {
    public Roles findByRoleNom(String rolenom);
}
