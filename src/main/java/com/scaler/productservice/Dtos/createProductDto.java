package com.scaler.productservice.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class createProductDto {
    String name;
    String description;
    String category;
    double price;
    String image;

   public createProductDto(String name, String description, String category, double price, String image) {
       this.name = name;
       this.description = description;
       this.category = category;
       this.price = price;
       this.image = image;
   }
}
