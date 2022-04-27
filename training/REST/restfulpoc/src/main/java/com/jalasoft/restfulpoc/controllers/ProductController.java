package com.jalasoft.restfulpoc.controllers;

import java.util.List;
import java.util.Optional;

import com.jalasoft.restfulpoc.models.ProductModel;
import com.jalasoft.restfulpoc.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public List<ProductModel> getProducts(){
        return productService.getProducts();
    }

    @PostMapping
    public ProductModel saveProduct(@RequestBody ProductModel product){
        // Data Validation
        return productService.saveProduct(product);
    }

    @GetMapping(path = "/{id}")
    public Optional<ProductModel> getProductById(@PathVariable("id") Long id){
        return productService.getById(id);
    }

    @GetMapping(path = "/query")
    public List<ProductModel> findByName(@RequestParam("name") String name){
        return productService.findByName(name);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteProduct(@PathVariable("id") Long id){
        boolean result = productService.deleteProduct(id);
        if(result){
            return String.format("Product id=%s was deleted", id);
        } else {
            return String.format("Product id=%s was not deleted", id);
        }
    }
}
