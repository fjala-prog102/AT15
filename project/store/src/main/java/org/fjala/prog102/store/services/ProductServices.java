package org.fjala.prog102.store.services;

import org.fjala.prog102.store.models.Product;
import org.fjala.prog102.store.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}