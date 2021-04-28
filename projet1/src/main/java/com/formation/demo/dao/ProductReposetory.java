package com.formation.demo.dao;

import com.formation.demo.entites.Product;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductReposetory extends JpaRepository<Product, Long> {
    @Query("select p from Product p where p.name like :x")
    List<Product> chercher(@Param("x") String mc);

    @Query("select p from Product p ")
    Page<Product> pagination(Pageable pageable);
    @Query("select p from Product p where p.description like :x")
    Page<Product> chercher2(@Param("x") String mc,Pageable p);
}
