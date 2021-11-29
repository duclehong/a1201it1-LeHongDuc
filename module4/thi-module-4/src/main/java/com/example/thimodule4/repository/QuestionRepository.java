package com.example.thimodule4.repository;

import com.example.thimodule4.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends PagingAndSortingRepository<Question,Integer> {
    Page<Question> findAllByTitleContaining(String title, Pageable pageable);
}