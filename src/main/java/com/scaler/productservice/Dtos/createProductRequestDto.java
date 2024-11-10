package com.scaler.productservice.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class createProductRequestDto {
    private String name;
    private String description;
    private String category;
    private double price;
    private String image;
}
