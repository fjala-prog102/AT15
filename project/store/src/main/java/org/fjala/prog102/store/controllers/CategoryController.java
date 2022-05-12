package org.fjala.prog102.store.controllers;

import java.util.List;
import org.fjala.prog102.store.models.Category;
import org.fjala.prog102.store.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryServices categoryServices;

    @GetMapping
    public List<Category> getCategories() {
        return categoryServices.getCategories();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Category saveCategory(@RequestBody Category category) {
        return categoryServices.saveCategory(category);
    }

    @PutMapping
    public Category updateCategory(@RequestBody Category category) {
        return categoryServices.updateCategory(category);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @GetMapping(path = "/{name}")
    public List<Category> findByName(@PathVariable("name") String name) {
        return categoryServices.findByName(name);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/{name}")
    public String deleteCategory(@PathVariable("name") String name) {
        boolean result = categoryServices.deleteCategory(name);
        if (result) {
            return String.format("Category name=%s was deleted", name);
        } else {
            return String.format("Category name=%s was  not deleted", name);
        }
    }
}
