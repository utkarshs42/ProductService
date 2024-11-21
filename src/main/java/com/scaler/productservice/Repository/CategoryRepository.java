package com.scaler.productservice.Repository;

import com.scaler.productservice.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
    Category save(Category category);
}
