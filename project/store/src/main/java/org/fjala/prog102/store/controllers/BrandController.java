package org.fjala.prog102.store.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotBlank;

import org.fjala.prog102.store.dto.RestResponseDto;
import org.fjala.prog102.store.exception.ResourceNotFoundException;
import org.fjala.prog102.store.models.Brand;
import org.fjala.prog102.store.services.BrandServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/brands")
@Validated
public class BrandController {
    @Autowired
    private BrandServices brandServices;

    @GetMapping
    public RestResponseDto<List<Brand>> getBrands() {
        RestResponseDto<List<Brand>> response = new RestResponseDto<>();
        response.setData(brandServices.getBrands());
        return response;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RestResponseDto<Brand> saveBrand(@RequestBody Brand brand) {
        RestResponseDto<Brand> response = new RestResponseDto<>();
        response.setData(brandServices.saveBrand(brand));
        return response;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @GetMapping(path = "/{name}")
    public Optional<Brand> findByName(@PathVariable("name") String name) {
        return brandServices.findBrandByName(name);
    }

    @DeleteMapping(path = "/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBrandByName(@NotBlank(message = "Brand name cannot be blank") @PathVariable("name") String name) {
        try {
            brandServices.deleteBrandByName(name);
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }
}