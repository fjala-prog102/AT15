package org.fjala.prog102.store.services;

import org.fjala.prog102.store.exception.ResourceNotFoundException;
import org.fjala.prog102.store.models.Product;
import org.fjala.prog102.store.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServices {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public Optional<Product> getById(Long productId) throws ResourceNotFoundException {
        if (productRepository.existsById(productId)) {
            return productRepository.findById(productId);
        } else {
            throw new ResourceNotFoundException("The Product with the providen ID does not exists");
        }

    }

    public Product saveProduct(Product product) throws ResourceNotFoundException {
        if (product.getProductId() == null) {
            return productRepository.saveAndFlush(product);
        } else {
            throw new ResourceNotFoundException("To create a new product, you do not have to set an ID");
        }
    }

    public Product updateProduct(Product product) throws ResourceNotFoundException {
        if (productRepository.existsById(product.getProductId())) {
            return productRepository.saveAndFlush(product);
        } else {
            throw new ResourceNotFoundException("The providen Product does not exists");
        }
    }

    public void deleteProduct(Long productId) throws ResourceNotFoundException {
        try {
            productRepository.deleteById(productId);
        } catch (Exception e) {
            throw new ResourceNotFoundException("The product with the providen id was not found", e);
        }
    }
}
