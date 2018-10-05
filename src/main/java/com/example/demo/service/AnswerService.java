package com.example.demo.service;

import com.example.demo.repository.AnswerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {

    private AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public List<String> getAll() {
        return this.answerRepository.getAll();
    }

    public void create( String answer ) {
        this.answerRepository.create(answer);
    }
}
