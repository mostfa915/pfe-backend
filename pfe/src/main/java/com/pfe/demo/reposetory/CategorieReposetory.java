package com.pfe.demo.reposetory;

import com.pfe.demo.entiter.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieReposetory extends JpaRepository<Categories,Long> {
}
