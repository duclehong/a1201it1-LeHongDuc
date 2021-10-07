package com.codegym.demo.controller;

import com.codegym.demo.model.Category;
import com.codegym.demo.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String showCategory(Model model){
        model.addAttribute("categories", categoryService.showCategories());
        return "/category/list";
    }
    @GetMapping("/create")
    public String showCreateForm(@ModelAttribute Category category){
        return "/category/create";
    }
}
