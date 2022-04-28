package org.fjala.prog102.store.services;

import java.util.ArrayList;

import org.fjala.prog102.store.models.Discount;
import org.fjala.prog102.store.repositories.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountServices {
    @Autowired
    DiscountRepository discountRepository;

    public ArrayList<Discount> getDiscounts() {
        return (ArrayList<Discount>) discountRepository.findAll();
    }

    public Discount saveDiscount(Discount discount) {
        return discountRepository.save(discount);
    }
}
