package org.fjala.prog102.store.services;

import java.util.List;

import org.fjala.prog102.store.models.Category;
import org.fjala.prog102.store.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServices {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getCategory() {
        return (List<Category>) categoryRepository.findAll();
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> findByName(String name) {
        return categoryRepository.findByName(name);
    }

    public boolean deleteCagetory(String name) {
        try {
            categoryRepository.deleteByName(name);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
