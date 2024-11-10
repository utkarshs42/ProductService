package com.scaler.productservice.Services;


import com.scaler.productservice.Dtos.createProductDto;
import com.scaler.productservice.Dtos.fakeStoreProductDto;
import com.scaler.productservice.Models.Products;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Products getProductDetails(Long id){
       fakeStoreProductDto responseDto = restTemplate.getForObject("https://fakestoreapi.com/products/" +id,
                                                                    fakeStoreProductDto.class);

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

}
