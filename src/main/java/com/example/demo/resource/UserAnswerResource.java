package com.example.demo.resource;

import com.example.demo.entity.UserAnswer;
import com.example.demo.exception.QuestionNotFoundException;
import com.example.demo.service.UserAnswerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserAnswerResource {

    private UserAnswerService userAnswerService;

    public UserAnswerResource(UserAnswerService userAnswerService) {
        this.userAnswerService = userAnswerService;
    }

    @GetMapping("/questions/{questionId}/userAnswers")
    public ResponseEntity<List<UserAnswer>> getAll(@PathVariable Long questionId) {
        return this.userAnswerService.getAll(questionId)
                .map(response -> ResponseEntity.ok().body(response))
                .orElseThrow(QuestionNotFoundException::new);
    }

}
