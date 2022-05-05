package org.fjala.prog102.store.controllers;

import java.util.List;
import org.fjala.prog102.store.models.Category;
import org.fjala.prog102.store.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryServices categoryServices;

    @GetMapping
    public List<Category> getCategories() {
        return categoryServices.getCategories();
    }

    @PostMapping
    public Category saveCategory(@RequestBody Category category) {
        return categoryServices.saveCategory(category);
    }

    @PutMapping
    public Category updateCategory(@RequestBody Category category) {
        return categoryServices.updateCategory(category);
    }

    @GetMapping(path = "/{name}")
    public List<Category> findByName(@PathVariable("name") String name) {
        return categoryServices.findByName(name);
    }

    @DeleteMapping(path = "/{name}")
    public String deleteCategory(@PathVariable("name") String name) {
        boolean result = categoryServices.deleteCagetory(name);
        if (result) {
            return String.format("Category name=%s was deleted", name);
        } else {
            return String.format("Category name=%s was  not deleted", name);
        }
    }
}
