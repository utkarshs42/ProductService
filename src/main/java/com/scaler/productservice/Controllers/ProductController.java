package com.scaler.productservice.Controllers;

import com.scaler.productservice.Dtos.createProductRequestDto;
import com.scaler.productservice.Models.Products;
import com.scaler.productservice.Services.ProductService;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/products")
    public Products createProduct(@RequestBody createProductRequestDto requestDto){
        return productService.createProduct(requestDto.getName(),requestDto.getDescription(),
                                            requestDto.getCategory(),requestDto.getPrice(),
                                            requestDto.getImage());
    }

}
