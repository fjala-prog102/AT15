package org.fjala.prog102.store.repositories;

import org.fjala.prog102.store.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
