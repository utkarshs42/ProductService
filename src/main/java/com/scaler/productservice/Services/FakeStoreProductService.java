package com.scaler.productservice.Services;


import com.scaler.productservice.Dtos.createProductDto;
import com.scaler.productservice.Dtos.fakeStoreProductDto;
import com.scaler.productservice.Exceptions.ProductNotFoundException;
import com.scaler.productservice.Models.Products;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Products getProductDetails(Long id) throws ProductNotFoundException {
       fakeStoreProductDto responseDto = restTemplate.getForObject("https://fakestoreapi.com/products/" +id,
                                                                    fakeStoreProductDto.class);
       if(responseDto == null){
           throw new ProductNotFoundException("Product not found, please try again later.");
       }
        Products product = responseDto.toProducts();
        return product;
    }

    @Override
    public Products createProduct(String name, String description, String category, double price, String image) {

       createProductDto newProduct = new createProductDto(name, description, category, price, image);

       fakeStoreProductDto responseDto =  restTemplate.postForObject("https://fakestoreapi.com/products",
                                        newProduct,fakeStoreProductDto.class);
       return responseDto.toProducts();
    }

    @Override
    public List<Products> getAllProducts() {
       fakeStoreProductDto[] responseDto = restTemplate.getForObject("https://fakestoreapi.com/products",
                                        fakeStoreProductDto[].class);
       List<Products> products = new ArrayList<>();
       for(int i =0;i<responseDto.length;i++){
           products.add(responseDto[i].toProducts());
       }
       return products;

    }


}
