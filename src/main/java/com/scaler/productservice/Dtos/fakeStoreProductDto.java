package com.scaler.productservice.Dtos;

import com.scaler.productservice.Models.Category;
import com.scaler.productservice.Models.Products;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class fakeStoreProductDto {
    private Long id;
    private String name;
    private String description;
    private String image;
    private String price;
    private String category;

   public Products toProducts(fakeStoreProductDto responseDto) {
       Products product = new Products();
       product.setId(responseDto.getId());
       product.setName(responseDto.getName());
       product.setDescription(responseDto.getDescription());
       product.setImage(responseDto.getImage());
       product.setPrice(Double.parseDouble(responseDto.getPrice()));

       Category category = new Category();
       category.setName(responseDto.getCategory());
       product.setCategory(category);

       return product;
   }

}
