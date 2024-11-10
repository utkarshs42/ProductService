package com.scaler.productservice.Controllers;

import com.scaler.productservice.Models.Products;
import com.scaler.productservice.Services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/products/{id}")
    public Products getProductDetails(@PathVariable("id") Long id){
        return productService.getProductDetails(id);
    }

}
