package com.example.demo.repository;

import com.example.demo.entity.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAnswerRepository extends JpaRepository<UserAnswer, Long> {

    public List<UserAnswer> findAllByQuestionId(Long questionId);
}
