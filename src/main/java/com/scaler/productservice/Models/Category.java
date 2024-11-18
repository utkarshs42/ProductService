package com.scaler.productservice.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel{
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Products> products;
}
