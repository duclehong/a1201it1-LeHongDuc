package com.codegym.demo.service;

import com.codegym.demo.model.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> showCategories();

    void saveCategory(Category category);

    void removeCategory(int id);

    Category findCategoryById(int id);

}
