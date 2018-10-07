package com.example.demo.service;

import com.example.demo.entity.Answer;
import com.example.demo.repository.AnswerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {

    private AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public List<Answer> getAll() {
        return this.answerRepository.findAll();
    }

    public void create( Answer answer ) {
        this.answerRepository.save(answer);
    }
}
