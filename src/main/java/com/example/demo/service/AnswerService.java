package com.example.demo.service;

import com.example.demo.entity.Answer;
import com.example.demo.entity.ChosenAnswer;
import com.example.demo.repository.AnswerRepository;
import com.example.demo.repository.ChosenAnswerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

    private AnswerRepository answerRepository;
    private QuestionService questionService;
    private ChosenAnswerRepository chosenAnswerRepository;

    public AnswerService(AnswerRepository answerRepository, QuestionService questionService, ChosenAnswerRepository chosenAnswerRepository) {
        this.answerRepository = answerRepository;
        this.questionService = questionService;
        this.chosenAnswerRepository = chosenAnswerRepository;
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

    public void choseAnAnswer(Long questionId, Long answerId) {
        ChosenAnswer newChosenAnswer = new ChosenAnswer();
        this.questionService.findOne(questionId)
                .map(question -> this.getById(answerId)
                        .map(answer -> {
                            newChosenAnswer.setAnswer(answer);
                            newChosenAnswer.setQuestion(question);

                             return this.chosenAnswerRepository.save(newChosenAnswer);
                        }));
    }

    public List<ChosenAnswer> getAllChosenAnswerByQuestionId(Long questionId) {
        return this.chosenAnswerRepository.findAllByQuestionId(questionId);
    }
}
