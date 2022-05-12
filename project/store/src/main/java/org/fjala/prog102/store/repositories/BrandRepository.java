package org.fjala.prog102.store.repositories;

import java.util.List;
import java.util.Optional;

import org.fjala.prog102.store.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, String> {

    Optional<Brand> findBrandByName(String brandName);

    List<Brand> deleteBrandByName(String brandName);
}
