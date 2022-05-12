package org.fjala.prog102.store.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.fjala.prog102.store.exception.ResourceNotFoundException;
import org.fjala.prog102.store.models.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

    @Test
    public void updateCategoryTest() {
        Category category = new Category();
        category.setName("computers");
        category.setDescription("blblbla");
        categoryServices.saveCategory(category);

        category.setDescription("new bjlbjlajbl");
        Category updatedCategory = categoryServices.updateCategory(category);
        assertNotNull(updatedCategory);
        assertEquals("new bjlbjlajbl", category.getDescription());
    }

    @Test
    public void updateUnexistingCategoryTest() {
        try {
            Category newCategory = new Category();
            newCategory.setName("computers");
            newCategory.setDescription("yadayadaydada");
            categoryServices.updateCategory(newCategory);
        } catch (RuntimeException myException) {
            assertEquals("The providen Category name does not exist.", myException.getMessage());
        }
    }

    @Test
    public void deleteCategoryTest() {

        Category category = new Category();
        category.setName("computers");
        category.setDescription("yadayadayada");
        categoryServices.saveCategory(category);
        try {
            categoryServices.deleteCategory(category.getName());
            assertFalse(categoryServices.findByName(category.getName()).isPresent());

            categoryServices.deleteCategory(category.getName());
        } catch (ResourceNotFoundException e) {
            assertEquals("The category with the providen name was not found", e.getMessage());
        }
    }
}
