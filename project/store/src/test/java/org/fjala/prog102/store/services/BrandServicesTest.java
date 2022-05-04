package org.fjala.prog102.store.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.fjala.prog102.store.models.Brand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BrandServicesTest {

    @Autowired
    private BrandServices brandServices;

    @Test
    public void getBrandsTest() {
        List<Brand> brands = brandServices.getBrands();
        assertNotNull(brands);
        assertTrue(brands.size() >= 0);
    }

    @Test
    public void saveBrandTest() {
        Brand brand = new Brand();
        brand.setName("Apple");
        brandServices.saveBrand(brand);
        assertNotNull(brand);
        assertTrue(brand.getProducts() == null || brand.getProducts().size() == 0);
    }
}