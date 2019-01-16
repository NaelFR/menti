package com.example.demo.resource;

import com.example.demo.entity.Question;
import com.example.demo.entity.Session;
import com.example.demo.exception.QuestionNotFoundException;
import com.example.demo.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class QuestionResource {

    private QuestionService questionService;

    public QuestionResource(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("sessions/{sessionId}/questions")
    public List<Question> getAll(@PathVariable Session sessionId) {
        return questionService.getAll(sessionId);
    }

    @PostMapping("/questions")
    public void create(@RequestBody Question question) {
        questionService.create(question);
    }

    @PutMapping("/questions/{questionId}/finish")
    public ResponseEntity<Question> finishQuestion(@PathVariable Long questionId) {
        return this.questionService.finishQuestion(questionId).map(
                question -> ResponseEntity.ok().body(question)
        ).orElseThrow(QuestionNotFoundException::new);
    }
}
