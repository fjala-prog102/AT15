package com.jalasoft.restfulpoc.services;

import java.util.List;
import java.util.Optional;

import com.jalasoft.restfulpoc.models.ProductModel;
import com.jalasoft.restfulpoc.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<ProductModel> getProducts(){
        return (List<ProductModel>) productRepository.findAll();
    }

    public ProductModel saveProduct(ProductModel product){
        return productRepository.save(product);
    }

    public Optional<ProductModel> getById(Long id){
        return productRepository.findById(id);
    }

    public List<ProductModel> findByName(String name){
        return productRepository.findByName(name);
    }

    public boolean deleteProduct(Long id){
        try {
            productRepository.deleteById(id);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
