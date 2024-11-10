package com.scaler.productservice.Services;


import com.scaler.productservice.Models.Products;

public interface ProductService {
    public Products getProductDetails(Long id);
    public Products createProduct(String name, String description,String category,double price,String image);

}
