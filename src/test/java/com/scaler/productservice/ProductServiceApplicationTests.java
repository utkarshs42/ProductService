package com.scaler.productservice;

import com.scaler.productservice.Repository.ProductRepository;
import com.scaler.productservice.Repository.ProductTitleAndDesc;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceApplicationTests {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void test1() {
        ProductTitleAndDesc product = productRepository.getProductData(1L);
        System.out.println(product.getname() + " , " + product.getDescription());
    }

}
