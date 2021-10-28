package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Blog;
import vn.codegym.model.Category;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    Blog findById(long id);

    void save(Blog blog);

    void remove(long id);

    void update(Blog blog);
    Page <Blog> findAllPage(Pageable pageable);
    Iterable<Blog> findAllByCategory(Category category);
    Page<Blog> findAllByNameContaining(String name, Pageable pageable);
}
