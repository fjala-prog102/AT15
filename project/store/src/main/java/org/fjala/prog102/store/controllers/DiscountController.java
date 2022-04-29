package org.fjala.prog102.store.controllers;

import java.util.ArrayList;

import org.fjala.prog102.store.models.Discount;
import org.fjala.prog102.store.services.DiscountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/discount")
public class DiscountController {
    @Autowired
    private DiscountServices discountServices;

    @GetMapping
    public ArrayList<Discount> getDiscounts() {
        return discountServices.getDiscounts();
    }

    @PostMapping
    public Discount saveDiscount(@RequestBody Discount discount) {
        return discountServices.saveDiscount(discount);
    }
}
