package vn.codegym.service;

import org.springframework.stereotype.Service;
import vn.codegym.model.Category;

@Service
public interface CategoryService {
    Iterable<Category> findAll();

    Category findById(int id);

    void save(Category category);

    void remove(int id);
}
