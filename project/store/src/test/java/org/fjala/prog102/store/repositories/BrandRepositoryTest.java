package org.fjala.prog102.store.repositories;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.fjala.prog102.store.models.Brand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class BrandRepositoryTest {

    @Autowired
    private BrandRepository brandRepository;

    @Test
    public void findBrandByNameTest() {
        Brand brand = brandRepository.findBrandByName("Unexisting brand name");
        assertNull(brand);
    }
}