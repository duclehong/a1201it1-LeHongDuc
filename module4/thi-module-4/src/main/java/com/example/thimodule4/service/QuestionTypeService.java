package com.example.thimodule4.service;

import com.example.thimodule4.model.Question;
import com.example.thimodule4.model.QuestionType;

public interface QuestionTypeService {
    Iterable<QuestionType> findAll();
}
