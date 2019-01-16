package com.example.demo.repository;

import com.example.demo.entity.Answer;
import com.example.demo.entity.ChosenAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChosenAnswerRepository extends JpaRepository<ChosenAnswer, Long> {

    public List<ChosenAnswer> findAllByQuestionId(Long questionId);
}
