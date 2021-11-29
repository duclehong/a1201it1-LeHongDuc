package com.example.thimodule4.service;

import com.example.thimodule4.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuestionService {
    Page<Question> findAll(Pageable pageable);
    void save(Question question);
    void delete(int id);
    Question findById(int id);
    Page<Question> findAllByTitleContaining(String title, Pageable pageable);
}
