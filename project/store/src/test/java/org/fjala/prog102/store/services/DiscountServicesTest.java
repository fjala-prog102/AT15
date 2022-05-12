package org.fjala.prog102.store.services;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;
import java.util.ArrayList;

import org.fjala.prog102.store.exception.ResourceNotFoundException;
import org.fjala.prog102.store.models.Discount;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DiscountServicesTest {
    @Autowired
    private DiscountServices discountServices;

    @Test
    public void getDiscountsTest() {
        ArrayList<Discount> discount = discountServices.getDiscounts();
        assertNotNull(discount);
        assertTrue(discount.size() >= 0);
    }

   @Test
    public void saveDiscountTest() {
        Discount discount = new Discount();
        discount.setPercentage(0.1);
        discount.setStartDate(new Date(1652304263));
        discount.setEndDate(new Date(1652304264));
        discount.setDescription("description");
        discountServices.saveDiscount(discount);
        assertNotNull(discount);
    }

    @Test
    public void updateDiscountTest() {
        Discount discount = new Discount();
        discount.setPercentage(0.1);
        discount.setStartDate(new Date(1652304263));
        discount.setEndDate(new Date(1652304264));
        discount.setDescription("description");
        discountServices.saveDiscount(discount);
        discount.setDescription("new description");
        discountServices.updateDiscount(discount);
        String description = "new description";
        assertEquals(description, discount.getDescription());
    }

    @Test
    public void updateDiscountFailTest() throws Exception {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            Discount discount = new Discount();
            discount.setDiscountId(100L);
            discount.setPercentage(0.1);
            discount.setStartDate(new Date(1652304263));
            discount.setEndDate(new Date(1652304264));
            discount.setDescription("description");
            discountServices.updateDiscount(discount);
        });
        String expectedMessage = "The given Discount does not exists";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void deleteDiscountTest() throws ResourceNotFoundException {
        Discount discount = new Discount();
        discount.setPercentage(0.1);
        discount.setStartDate(new Date(1652304263));
        discount.setEndDate(new Date(1652304264));
        discount.setDescription("description");
        discountServices.saveDiscount(discount);
        discountServices.deleteDiscount(discount.getDiscountId());
        assertNotNull(discountServices.getDiscountById(discount.getDiscountId()));
    }

    @Test
    public void deleteDiscountFailTest() throws ResourceNotFoundException {
        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            discountServices.deleteDiscount(123L);
        });
        String expectedMessage = "The discount with the given id was not found";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
