package org.fjala.prog102.store.repositories;

import org.fjala.prog102.store.models.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount, Long> {

}
