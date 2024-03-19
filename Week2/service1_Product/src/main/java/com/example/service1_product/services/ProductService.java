package com.example.service1_product.services;


import com.example.service1_product.models.Product;
import com.example.service1_product.models.User;
import com.example.service1_product.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final RestTemplate restTemplate;


    @Autowired
    public ProductService(ProductRepository productRepository, RestTemplate restTemplate) {
        this.productRepository = productRepository;
        this.restTemplate = restTemplate;
    }

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public Product getProductById(long id){
        User user = restTemplate.getForObject("http://localhost:8081/api/v1/users/"+id, User.class);
        Product product = productRepository.findById(id).get();
        product.setUser(user);
        return product;
    }

}