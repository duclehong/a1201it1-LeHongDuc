package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/category")
    public String list(@RequestParam("search") Optional<String> s, Model model, @PageableDefault(value = 5) Pageable pageable){
        Page<Category> categories;
        if (s.isPresent()){
            categories = categoryService.findAllByNameContaining(s.get(), pageable);
        }else {
            categories = categoryService.findAll(pageable);
        }
        model.addAttribute("categogy", categories);
        return "/category/index";
    }

    @GetMapping("/create-category")
    public String showCreate(Model model){
        model.addAttribute("category", new Category());
        return "/category/create";
    }

    @PostMapping("create-category")
    public String create(Model model,Category category ,RedirectAttributes redirectAttributes){
        categoryService.save(category);
        model.addAttribute("category", category);
        redirectAttributes.addFlashAttribute("msgCreate", "Create category successfully");
        return "redirect:/category";
    }

    @GetMapping("edit-category/{id}")
    public String showEdit(Model model, @PathVariable Long id){
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "/category/edit";
    }

    @PostMapping("edit-category")
    public String edit(Model model, Category category, RedirectAttributes redirectAttributes){
        categoryService.save(category);
        model.addAttribute("category", category);
        redirectAttributes.addFlashAttribute("msgEdit", "Edit category successfully");
        return "redirect:/category";
    }
    @GetMapping("/delete-category/{id}")
    public String showDelete(Model model, @PathVariable Long id){
        Category category = categoryService.findById(id);
        model.addAttribute(category);
        return "/category/delete";
    }
    @PostMapping("delete-category")
    public String delete(Category category, RedirectAttributes redirectAttributes){
        categoryService.remove(category.getId());
        redirectAttributes.addFlashAttribute("msgDelete", "Delete category successfully");
        return "redirect:/category";
    }
}
