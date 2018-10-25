package com.example.demo.service;

import com.example.demo.entity.Answer;
import com.example.demo.repository.AnswerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

    private AnswerRepository answerRepository;
    private QuestionService questionService;

    public AnswerService(AnswerRepository answerRepository, QuestionService questionService) {
        this.answerRepository = answerRepository;
        this.questionService = questionService;
    }

    public List<Answer> getAll() {
        return this.answerRepository.findAll();
    }

    public List<Answer> getByQuestionId(Long questionId) {
        return this.answerRepository.findByQuestionId(questionId);
    }

    public Optional<Answer> create(Long questionId, Answer answer ) {
        return this.questionService.findOne(questionId)
                .map(question -> {
                    answer.setQuestion(question);
                    return this.answerRepository.save(answer);
                });
    }

    public Optional<Answer> getById(Long answerId) {
        return this.answerRepository.findById(answerId);
    }
}
