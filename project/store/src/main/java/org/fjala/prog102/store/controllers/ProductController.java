package org.fjala.prog102.store.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.fjala.prog102.store.dto.RestResponseDto;
import org.fjala.prog102.store.exception.ResourceNotFoundException;
import org.fjala.prog102.store.models.Product;
import org.fjala.prog102.store.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/products")
@Validated
public class ProductController {
    @Autowired
    private ProductServices productServices;

    @GetMapping
    public RestResponseDto<List<Product>> getProducts() {
        RestResponseDto<List<Product>> response = new RestResponseDto<>();
        response.setData(productServices.getProducts());
        return response;
    }

    @GetMapping(path = "/{productId}")
    public RestResponseDto<Optional<Product>> getProductById(@NotNull(message = "A product Id must be specified")
        @PathVariable("productId") Long productId) {
        RestResponseDto<Optional<Product>> response = new RestResponseDto<>();
        response.setData(productServices.getById(productId));
        return response;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RestResponseDto<Product> saveProduct(@RequestBody Product product) {
        RestResponseDto<Product> response = new RestResponseDto<>();
        try {
            response.setData(productServices.saveProduct(product));
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
        return response;
    }

    @PutMapping
    public RestResponseDto<Product> updateProduct(@RequestBody Product product) {
        RestResponseDto<Product> response = new RestResponseDto<>();
        try {
            response.setData(productServices.updateProduct(product));
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
        return response;
    }

    @DeleteMapping(path = "/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@NotNull(message = "productId cannot be null") @PathVariable("productId") Long productId) {
        try {
            productServices.deleteProduct(productId);
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }
}