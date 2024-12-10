package com.scaler.productservice.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
public class Products extends BaseModel implements Serializable {
    private String name;
    private String description;
    private double price;
    private String image;

    @ManyToOne
    private Category category;
}
