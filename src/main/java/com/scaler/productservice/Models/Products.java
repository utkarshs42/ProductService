package com.scaler.productservice.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Products {
    private Long id;
    private String name;
    private String description;
    private double price;
    private String image;
    private Category category;
}
