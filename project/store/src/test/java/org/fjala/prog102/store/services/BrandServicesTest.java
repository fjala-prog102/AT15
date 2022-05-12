package org.fjala.prog102.store.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.fjala.prog102.store.exception.ResourceNotFoundException;
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

    @Test
    public void updateBrandTest() {
        Brand brand = new Brand();
        brand.setName("Apple");
        brandServices.saveBrand(brand);
        brand.setWebsite("www.google.com");
        brandServices.updateBrand(brand);
        assertEquals("www.google.com", brand.getWebsite());
    }

    @Test
    public void updateNoFoundBrandTest() throws RuntimeException {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            Brand brand = new Brand();
            brand.setName("Nokia");
            brand.setWebsite("www.google.com");
            brandServices.updateBrand(brand);
        });
        String expectedMessage = "The providen Brand name does not exist.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    //@Test
    // public void deleteBrandTest() throws Exception{
    //     Brand brand = new Brand();
    //     brand.setName("Apple");
    //     brandServices.saveBrand(brand);
    //     brand.setWebsite("www.google.com");
    //     brandServices.deleteBrandByName(brand.getName());
    //     assertEquals("www.google.com", brand.getWebsite());
    // }

}