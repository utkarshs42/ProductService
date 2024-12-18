package com.scaler.productservice.Services;


import com.scaler.productservice.Exceptions.ProductNotFoundException;
import com.scaler.productservice.Models.Products;

import java.util.List;

public interface ProductService {
    public Products getProductDetails(Long id) throws ProductNotFoundException;
    public Products createProduct(String name, String description,String category,double price,String image);
    public List<Products> getAllProducts();
}
