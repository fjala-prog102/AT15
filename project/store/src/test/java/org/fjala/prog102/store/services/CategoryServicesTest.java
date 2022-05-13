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
    public void saveCategoriesTest() throws ResourceNotFoundException {
        Category category = new Category();
        category.setName("Example");
        categoryServices.saveCategory(category);
        assertNotNull(category);
        assertTrue(category.getProducts() == null || category.getProducts().size() == 0);
        categoryServices.deleteCategory("Example");
    }

    @Test
    public void itShouldNotSaveAExistingCategory() throws ResourceNotFoundException {
        Category category = new Category();
        category.setName("Fruits");
        categoryServices.saveCategory(category);
        try {
            Category category2 = new Category();
            category2.setName("Fruits");
            categoryServices.saveCategory(category2);
        } catch (RuntimeException e) {
            assertEquals("Cannot create a new category with the same name as an existing one.", e.getMessage());
        }
        categoryServices.deleteCategory("Fruits");
    }

    @Test
    public void updateCategoryTest() throws ResourceNotFoundException {
        Category category = new Category();
        category.setName("computers");
        category.setDescription("blblbla");
        categoryServices.saveCategory(category);

        category.setDescription("new bjlbjlajbl");
        Category updatedCategory = categoryServices.updateCategory(category);
        assertNotNull(updatedCategory);
        assertEquals("new bjlbjlajbl", category.getDescription());
        categoryServices.deleteCategory("computers");
    }

    @Test
    public void updateUnexistingCategoryTest() {
        try {
            Category newCategory = new Category();
            newCategory.setName("Laptops");
            newCategory.setDescription("Laptops description");
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
