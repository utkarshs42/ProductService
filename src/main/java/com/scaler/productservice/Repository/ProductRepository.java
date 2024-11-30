package com.scaler.productservice.Repository;

import com.scaler.productservice.Models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Products,Long> {
    Products save(Products product);


    Optional<Products> findById(Long id);


    List<Products> findAll();

    @Query(value = "Select name,description from products where id = :id ", nativeQuery = true)
    ProductTitleAndDesc getProductData(@Param("id") Long id);
}
