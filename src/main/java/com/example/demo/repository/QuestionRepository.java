package com.example.demo.repository;

import com.example.demo.entity.Question;
import com.example.demo.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    public Question findOneById(Long questionId);

    public List<Question> findAllBySessionId(Session sessionId);
}
