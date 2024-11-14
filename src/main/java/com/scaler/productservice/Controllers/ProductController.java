package com.scaler.productservice.Controllers;

import com.scaler.productservice.Dtos.createProductRequestDto;
import com.scaler.productservice.Dtos.errorDto;
import com.scaler.productservice.Exceptions.ProductNotFoundException;
import com.scaler.productservice.Models.Products;
import com.scaler.productservice.Services.ProductService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{id}")
    public Products getProductDetails(@PathVariable("id") Long id) throws ProductNotFoundException {
        return productService.getProductDetails(id);
    }

    @PostMapping("/products")
    public Products createProduct(@RequestBody createProductRequestDto requestDto) {
        return productService.createProduct(requestDto.getName(), requestDto.getDescription(),
                requestDto.getCategory(), requestDto.getPrice(),
                requestDto.getImage());
    }
    @GetMapping("/products")
    public List<Products> getAllProducts(){
         return productService.getAllProducts();
    }
/*
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<errorDto> handleNPEException (){
        errorDto error = new errorDto();
        error.setMessage("Something went wrong");
        ResponseEntity<errorDto> responseEntity = new ResponseEntity<>
                                        (error, HttpStatusCode.valueOf(501));
        return responseEntity;
    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<errorDto> handlePNFException(){
        errorDto error = new errorDto();
        error.setMessage("Product not found");
        ResponseEntity<errorDto> responseEntity = new ResponseEntity<>
                                                   (error,HttpStatusCode.valueOf(404));
        return responseEntity;
        //Exceptions occured in product controller class will be handled here but if this Exception
        //occured somewhere else it won't get handled and we need to copy paste this logic so we can use advices

    }
 */


}

