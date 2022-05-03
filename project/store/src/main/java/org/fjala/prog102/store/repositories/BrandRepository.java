package org.fjala.prog102.store.repositories;

import java.util.List;
import org.fjala.prog102.store.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    Brand findBrandByName(String brandName);

    List<Brand> deleteBrandByName(String brandName);
}
