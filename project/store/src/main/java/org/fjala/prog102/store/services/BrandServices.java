package org.fjala.prog102.store.services;

import java.util.List;
import java.util.Optional;

import org.fjala.prog102.store.exception.ResourceNotFoundException;
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

    public Optional<Brand> findBrandByName(String name) {
        return brandRepository.findBrandByName(name);
    }

    public void deleteBrandByName(String name) throws ResourceNotFoundException {
        try {
            brandRepository.deleteById(name);
        } catch (Exception e) {
            throw new ResourceNotFoundException(String.format("Brand %s was not found", name), e);
        }
    }

    public Brand updateBrand(Brand brand) {
        if (brandRepository.existsById(brand.getName())) {
            return brandRepository.saveAndFlush(brand);
        } else {
            throw new RuntimeException("The providen Brand name does not exist.");
        }
    }
}
