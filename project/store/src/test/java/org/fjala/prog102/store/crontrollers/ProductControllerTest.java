package org.fjala.prog102.store.crontrollers;

import org.fjala.prog102.store.controllers.ProductController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProductControllerTest {
    @Autowired
    private ProductController productController;

    @Test
    public void itShouldListDiscounts() {
        assertThat(productController).isNotNull();
    }
}
