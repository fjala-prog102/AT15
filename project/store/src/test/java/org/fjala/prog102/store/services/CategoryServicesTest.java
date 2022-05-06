package org.fjala.prog102.store.services;

import org.fjala.prog102.store.models.Brand;
import org.fjala.prog102.store.models.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CategoryServicesTest {

    @Autowired
    private CategoryServices categoryServices;

    @Test
    public void getCategoriesTest() {
        List<Category> categories = categoryServices.getCategories();
        assertNotNull(categories);
        assertTrue(categories.size() >= 0);
    }

    @Test
    public void saveCategoriesTest() {
        Category category = new Category();
        category.setName("Fruits");
        categoryServices.saveCategory(category);
        assertNotNull(category);
        assertTrue(category.getProducts() == null || category.getProducts().size() == 0);
    }
}
