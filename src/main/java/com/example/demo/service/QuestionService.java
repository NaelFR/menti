package com.example.demo.service;

import com.example.demo.entity.Question;
import com.example.demo.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    private QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Optional<Question> findOne(Long questionId) {
        return this.questionRepository.findById(questionId);
    }

    public List<Question> getAll() {
        return this.questionRepository.findAll();
    }

    public void create(Question question) {
        this.questionRepository.save(question);
    }
}
