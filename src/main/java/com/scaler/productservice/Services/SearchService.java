package com.scaler.productservice.Services;

import com.scaler.productservice.Models.Products;
import com.scaler.productservice.Repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

    private ProductRepository productRepository;

    public SearchService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Products> search(String Query, int PageNumber, int PageSize){
        Pageable pageable = PageRequest.of(PageNumber, PageSize);
        return productRepository.findByNameContaining(Query,pageable);
    }
}
