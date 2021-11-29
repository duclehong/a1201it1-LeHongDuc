package com.example.thimodule4.service.impl;

import com.example.thimodule4.model.Question;
import com.example.thimodule4.model.QuestionType;
import com.example.thimodule4.repository.QuestionRepository;
import com.example.thimodule4.repository.QuestionTypeRepository;
import com.example.thimodule4.service.QuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionTypeServiceImpl implements QuestionTypeService {
    @Autowired
    QuestionTypeRepository questionTypeRepository;

    @Override
    public Iterable<QuestionType> findAll() {
        return questionTypeRepository.findAll();
    }
}
