package com.scaler.productservice.Services;

import com.scaler.productservice.Exceptions.ProductNotFoundException;
import com.scaler.productservice.Models.Products;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DBProductService")
public class DBProductService implements ProductService {
    @Override
    public Products getProductDetails(Long id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public Products createProduct(String name, String description, String category, double price, String image) {
        return null;
    }

    @Override
    public List<Products> getAllProducts() {
        return List.of();
    }
}
