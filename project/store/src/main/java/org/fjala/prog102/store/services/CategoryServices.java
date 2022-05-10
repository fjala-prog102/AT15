package org.fjala.prog102.store.services;

import java.util.List;
import org.fjala.prog102.store.models.Category;
import org.fjala.prog102.store.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServices {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getCategories() {
        return (List<Category>) categoryRepository.findAll();
    }

    public Category saveCategory(Category category) {
        if (categoryRepository.existsById(category.getName())) {
            throw new RuntimeException("Cannot create a new category with the same name as an existing one.");
        } else {
            return categoryRepository.saveAndFlush(category);
        }
    }

    public List<Category> findByName(String name) {
        return categoryRepository.findByName(name);
    }

    public boolean deleteCategory(String name) {
        try {
            categoryRepository.deleteById(name);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Category updateCategory(Category category) {
        if (categoryRepository.existsById(category.getName())) {
            return categoryRepository.saveAndFlush(category);
        } else {
            throw new RuntimeException("The providen Category name does not exist.");
        }
    }
}
