package org.fjala.prog102.store.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.fjala.prog102.store.models.Brand;
import org.fjala.prog102.store.models.Product;
import org.fjala.prog102.store.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandServices {
    @Autowired
    private BrandRepository brandRepository;

    public List<Brand> getBrands() {
        return (List<Brand>) brandRepository.findAll();
    }

    public Optional<Brand> getBrandByName(String brandName) {
        return brandRepository.findById(brandName);

    }
    public Brand saveBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    public List<Product> getProductsByBrandName(String brandName) {
        Optional<Brand> brand = getBrandByName(brandName);
        if (brand.isPresent()) {
            List<Product> productList = new ArrayList<>(brand.get().getProducts());
            return productList;
        } else {
            return Collections.emptyList();
        }
    }
}
