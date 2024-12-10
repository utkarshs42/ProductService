package com.scaler.productservice.Services;

import com.scaler.productservice.Configruations.RedisConfigruations;
import com.scaler.productservice.Exceptions.ProductNotFoundException;
import com.scaler.productservice.Models.Category;
import com.scaler.productservice.Models.Products;
import com.scaler.productservice.Repository.CategoryRepository;
import com.scaler.productservice.Repository.ProductRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("DBProductService")
public class DBProductService implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private RedisTemplate<String,Object> redisTemplate;
    public DBProductService(ProductRepository productRepository, CategoryRepository categoryRepository ,
                            RedisTemplate<String,Object> redisTemplate) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.redisTemplate = redisTemplate;
    }


    @Override
    public Products getProductDetails(Long id) throws ProductNotFoundException {
        Products productfromcache = (Products) redisTemplate.opsForValue().get(String.valueOf(id));
        if(productfromcache != null) {
            return productfromcache;
        }
        Optional<Products> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new ProductNotFoundException("Product not found");
        }
        Products productfromdb = product.get();
        redisTemplate.opsForValue().set(String.valueOf(id),productfromdb);
        return product.orElse(null);
    }

    @Override
    public Products createProduct(String name, String description, String category, double price, String image) {
        Products product = new Products();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setImage(image);

        Category categoryfromDB =  categoryRepository.findByName(category);
        if(categoryfromDB == null) {
            Category newCategory = new Category();
            newCategory.setName(category);

            categoryfromDB = categoryRepository.save(newCategory);

        }
        product.setCategory(categoryfromDB);

        return productRepository.save(product);

    }

    @Override
    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }
}
