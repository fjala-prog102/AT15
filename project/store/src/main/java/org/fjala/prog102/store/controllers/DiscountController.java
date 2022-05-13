package org.fjala.prog102.store.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.fjala.prog102.store.dto.RestResponseDto;
import org.fjala.prog102.store.exception.ResourceNotFoundException;
import org.fjala.prog102.store.models.Discount;
import org.fjala.prog102.store.services.DiscountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/discounts")
@Validated
public class DiscountController {
    @Autowired
    private DiscountServices discountServices;

    @GetMapping
    public RestResponseDto<ArrayList<Discount>> getDiscounts() {
        RestResponseDto<ArrayList<Discount>> response = new RestResponseDto<>();
        response.setData(discountServices.getDiscounts());
        return response;
    }

    @GetMapping(path = "/{discountId}")
    public RestResponseDto<Optional<Discount>> getDiscountById(@PathVariable("discountId") Long discountId) {
        RestResponseDto<Optional<Discount>> response = new RestResponseDto<>();
        response.setData(discountServices.getDiscountById(discountId));
        return response;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RestResponseDto<Discount> saveDiscount(@RequestBody Discount discount) {
        RestResponseDto<Discount> response = new RestResponseDto<>();
        response.setData(discountServices.saveDiscount(discount));
        return response;
    }

    @PutMapping
    public RestResponseDto<Discount> updateDiscount(@RequestBody Discount discount) {
        RestResponseDto<Discount> response = new RestResponseDto<>();
        response.setData(discountServices.updateDiscount(discount));
        response.setErrors(new ArrayList<String>());
        response.getErrors().add("Test");
        return response;
    }

    @DeleteMapping(path = "/{discountId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDiscount(@PathVariable("discountId") Long discountId) {
        try {
            discountServices.deleteDiscount(discountId);
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }
}
