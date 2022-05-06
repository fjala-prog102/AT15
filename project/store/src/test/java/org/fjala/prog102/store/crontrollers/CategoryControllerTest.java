package org.fjala.prog102.store.crontrollers;

import org.fjala.prog102.store.controllers.CategoryController;
import org.fjala.prog102.store.controllers.DiscountController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CategoryControllerTest {
    @Autowired
    private CategoryController categoryController;

    @Test
    public void itShouldListCategories() {
        assertThat(categoryController).isNotNull();
    }
}
