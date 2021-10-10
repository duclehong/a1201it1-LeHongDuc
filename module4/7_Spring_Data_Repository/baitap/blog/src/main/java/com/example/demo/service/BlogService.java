package com.example.demo.service;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {
    public Page<Blog> findAll(Pageable pageable);
    public Blog findById(Long id);
    public void save(Blog blog);
    public void remove(Long id);
    public Page<Blog> findAllByFirstNameContaining(String name, Pageable pageable);
}