package org.fjala.prog102.store.repositories;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.fjala.prog102.store.models.Brand;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class BrandRepositoryTest {

    @Autowired
    private BrandRepository brandRepository;

    @BeforeEach
    public void init() {
        Brand testData = new Brand();
        testData.setName("Brand 007");
        testData.setDescription("Brand 007 description");
        brandRepository.saveAndFlush(testData);
    }

    @AfterEach
    public void cleanUp() {
        try {
            Brand testData = new Brand();
            testData.setName("Brand 007");
            brandRepository.delete(testData);
        } catch (Exception e) {
            //Already deleted
        }
    }

    @Test
    public void findBrandByNameTest() {
        Brand brand = brandRepository.findBrandByName("Unexisting brand name");
        assertNull(brand);
    }

    @Test
    public void deleteBrandByName() {
        brandRepository.deleteById("Brand 007");
        assertFalse(brandRepository.findById("Brand 007").isPresent());
    }
}