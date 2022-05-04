package org.fjala.prog102.store.services;

import org.fjala.prog102.store.models.Product;
import org.fjala.prog102.store.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public Product saveProduct(Product product) {
        if (productRepository.existsById(product.getProductId())) {
            throw new RuntimeException("Cannot create a new Product with an existing ID");
        } else {
            return productRepository.saveAndFlush(product);
        }
    }

    public Product updateProduct(Product product) {
        if (productRepository.existsById(product.getProductId())) {
            return productRepository.saveAndFlush(product);
        } else {
            throw new RuntimeException("The providen Product does not exists");
        }
    }

    public boolean deleteProduct(Long productId) {
        try {
            productRepository.deleteById(productId);
            return true;
        } catch(Exception e) {
            return false;
        }
    }
}
