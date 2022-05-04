package org.fjala.prog102.store.crontrollers;

import org.fjala.prog102.store.controllers.DiscountController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DiscountControllerTest {
    @Autowired
    private DiscountController discountController;

    @Test
    public void itShouldListDiscounts() {
        assertThat(discountController).isNotNull();
    }
}
