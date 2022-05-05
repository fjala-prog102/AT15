package org.fjala.prog102.store.services;

import java.util.List;

import org.fjala.prog102.store.models.Brand;
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

    public Brand saveBrand(Brand brand) {
        return brandRepository.saveAndFlush(brand);
    }

    public Brand findBrandByName(String name) {
        return brandRepository.findBrandByName(name);
    }

    public boolean deleteBrandByName(String name) {
        try {
            brandRepository.deleteById(name);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
