package org.fjala.prog102.store.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.fjala.prog102.store.models.Discount;
import org.fjala.prog102.store.services.DiscountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/discounts")
public class DiscountController {
    @Autowired
    private DiscountServices discountServices;

    @GetMapping
    public ArrayList<Discount> getDiscounts() {
        return discountServices.getDiscounts();
    }

    @GetMapping(path = "/{discountId}")
    public Optional<Discount> getDiscountById(@PathVariable("discountId") Long discountId) {
        return discountServices.getDiscountById(discountId);
    }

    @PostMapping
    public Discount saveDiscount(@RequestBody Discount discount) {
        return discountServices.saveDiscount(discount);
    }

    @PutMapping
    public Discount updateDiscount(@RequestBody Discount discount) {
        return discountServices.updateDiscount(discount);
    }

    @DeleteMapping(path = "/{discountId}")
    public String deleteDiscount(@PathVariable("discountId") Long discountId) {
        boolean result = discountServices.deleteDiscount(discountId);
        if (result) {
            return String.format("Discount with id= %s was deleted", discountId);
        } else {
            return String.format("Discount with id= %s does not exist", discountId);
        }
    }
}
