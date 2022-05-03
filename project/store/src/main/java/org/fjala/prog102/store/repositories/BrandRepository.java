package org.fjala.prog102.store.repositories;

import java.util.List;
import org.fjala.prog102.store.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    public abstract Brand findBrandByName(String brandName);
    public abstract List<Brand> deleteBrandByName(String brandName);
}
