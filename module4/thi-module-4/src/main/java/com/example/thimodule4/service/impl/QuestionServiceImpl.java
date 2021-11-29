package com.example.thimodule4.service.impl;

import com.example.thimodule4.model.Coin;
import com.example.thimodule4.model.Question;
import com.example.thimodule4.repository.CoinRepository;
import com.example.thimodule4.repository.QuestionRepository;
import com.example.thimodule4.service.CoinService;
import com.example.thimodule4.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    @Override
    public Page<Question> findAll(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }

    @Override
    public void save(Question question) {
        questionRepository.save(question);
    }

    @Override
    public void delete(int id) {
        questionRepository.deleteById(id);
    }

    @Override
    public Question findById(int id) {
        return questionRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Question> findAllByTitleContaining(String title, Pageable pageable) {
        return questionRepository.findAllByTitleContaining(title, pageable);
    }
}
