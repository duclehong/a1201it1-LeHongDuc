package com.codegym.demo.service.impl;

import com.codegym.demo.model.Category;
import com.codegym.demo.repository.CategoryRepository;
import com.codegym.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> showCategories() {
        return categoryRepository.findAll();
//        return null;
    }

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void removeCategory(int id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category findCategoryById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }
}
