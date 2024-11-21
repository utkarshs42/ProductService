package com.scaler.productservice.Repository;

import com.scaler.productservice.Models.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Products,Long> {
    Products save(Products product);


    Optional<Products> findById(Long id);


    List<Products> findAll();
}
