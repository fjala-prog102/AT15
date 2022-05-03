package org.fjala.prog102.store.controllers;

import java.util.List;
import java.util.Optional;

import org.fjala.prog102.store.models.Brand;
import org.fjala.prog102.store.models.Product;
import org.fjala.prog102.store.services.BrandServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brands")
public class BrandController {
    @Autowired
    private BrandServices brandServices;

    @GetMapping
    public List<Brand> getBrands() {
        return brandServices.getBrands();
    }

    @GetMapping(path = "/{name}")
    public Optional<Brand> getBrandByName(@PathVariable("name") String brandName) {
        return brandServices.getBrandByName(brandName);
    }

    @GetMapping(path = "/{name}/products")
    public List<Product> getProductsByBrandName(@PathVariable("name") String brandName) {
        return brandServices.getProductsByBrandName(brandName);
    }

    @PostMapping
    public Brand saveBrand(@RequestBody Brand brand) {
        return brandServices.saveBrand(brand);
    }
}
