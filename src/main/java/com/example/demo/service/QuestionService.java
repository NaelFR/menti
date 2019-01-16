package com.example.demo.service;

import com.example.demo.entity.Question;
import com.example.demo.entity.Session;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    private QuestionRepository questionRepository;
    private SessionRepository sessionRepository;

    public QuestionService(QuestionRepository questionRepository, SessionRepository sessionRepository) {
        this.questionRepository = questionRepository;
        this.sessionRepository = sessionRepository;
    }

    public Optional<Question> findOne(Long questionId) {
        return this.questionRepository.findById(questionId);
    }

    public List<Question> getAll(Session sessionId) {
        return this.questionRepository.findAllBySessionId(sessionId);
    }

    public void create(Question question) {
        this.questionRepository.save(question);
    }

    public Optional<Question> finishQuestion(Long questionId) {
        return this.questionRepository.findById(questionId)
                .map(question -> {
                    question.setFinished(true);
                    return this.questionRepository.save(question);
                });
    }
}
