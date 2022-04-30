package org.fjala.prog102.store.controllers;

import java.util.List;

import org.fjala.prog102.store.models.Product;
import org.fjala.prog102.store.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductServices productServices;

    @GetMapping
    public List<Product> getProducts() {
        return productServices.getProducts();
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return productServices.saveProduct(product);
    }

    @DeleteMapping(path = "/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId) {
        boolean result = productServices.deleteProduct(productId);
        if (result) {
            return String.format("Product with id=%s was deleted", productId);
        } else {
            return String.format("Product with id=%s was not able to be deleted", productId);
        }
    }
}