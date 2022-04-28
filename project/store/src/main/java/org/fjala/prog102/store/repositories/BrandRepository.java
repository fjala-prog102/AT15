package org.fjala.prog102.store.repositories;

import org.fjala.prog102.store.models.Brand;
import org.springframework.data.repository.CrudRepository;

public interface BrandRepository extends CrudRepository<Brand, Long> {

}
