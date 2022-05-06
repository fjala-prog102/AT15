package org.fjala.prog102.store.services;

import java.util.ArrayList;
import java.util.Optional;

import org.fjala.prog102.store.models.Discount;
import org.fjala.prog102.store.repositories.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountServices {
    @Autowired
    private DiscountRepository discountRepository;

    public ArrayList<Discount> getDiscounts() {
        return (ArrayList<Discount>) discountRepository.findAll();
    }

    public Discount saveDiscount(Discount discount) {
        if (discount.getDiscountId() == null) {
            return discountRepository.save(discount);
        } else {
            throw new RuntimeException("To create a new discount, you do not have to set an ID");
        }
    }

    public Discount updateDiscount(Discount discount) {
        if (discountRepository.existsById(discount.getDiscountId())) {
            return discountRepository.saveAndFlush(discount);
        } else {
            throw new RuntimeException("The given Discount does not exists");
        }
    }

    public boolean deleteDiscount(Long discountID) {
        try {
            discountRepository.deleteById(discountID);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Optional<Discount> getById(Long id) {
        return discountRepository.findById(id);
    }
}
