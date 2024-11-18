package com.scaler.productservice.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Products extends BaseModel {
    private String name;
    private String description;
    private double price;
    private String image;

    @ManyToOne
    private Category category;
}
