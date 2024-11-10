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

   public Products toProducts() {
       Products product = new Products();
       product.setId(getId());
       product.setName(getName());
       product.setDescription(getDescription());
       product.setImage(getImage());
       product.setPrice(Double.parseDouble(getPrice()));

       Category category = new Category();
       category.setName(getCategory());
       product.setCategory(category);

       return product;
   }

}
