package com.example.demo.service;

import com.example.demo.entity.UserAnswer;
import com.example.demo.repository.UserAnswerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAnswerService {
    private QuestionService questionService;
    private UserAnswerRepository userAnswerRepository;

    public UserAnswerService(QuestionService questionService, UserAnswerRepository userAnswerRepository) {
        this.questionService = questionService;
        this.userAnswerRepository = userAnswerRepository;
    }

    public Optional<List<UserAnswer>> getAll(Long questionId) {
        return this.questionService.findOne(questionId)
                .map(question -> this.userAnswerRepository.findAllByQuestionId(question.getId()));
    }
}
