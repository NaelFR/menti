package com.example.demo.resource;

import com.example.demo.entity.Answer;
import com.example.demo.entity.ChosenAnswer;
import com.example.demo.exception.AnswerNotFoundException;
import com.example.demo.exception.QuestionNotFoundException;
import com.example.demo.service.AnswerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController()
public class AnswerResource {

    private AnswerService answerService;

    public AnswerResource (AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping("/questions/{questionId}/answers")
    public List<Answer> getAll(@PathVariable Long questionId) {
        return answerService.getByQuestionId(questionId);
    }

    @PostMapping("/questions/{questionId}/answers")
    public Answer create(@PathVariable Long questionId,
                       @Valid @RequestBody Answer answer) {
        return answerService.create(questionId, answer).orElseThrow(QuestionNotFoundException::new);
    }

    @GetMapping("/answers/{answerId}")
    public ResponseEntity<Answer> getById(@PathVariable Long answerId) {
        return answerService.getById(answerId).map(answer -> ResponseEntity.ok().body(answer)).orElseThrow(AnswerNotFoundException::new);
    }

    @PostMapping("/questions/{questionId}/choseAnswer/{answerId}")
    public void choseAnAnswer(@PathVariable Long questionId, @PathVariable Long answerId) {
        answerService.choseAnAnswer(questionId, answerId);
    }

    @GetMapping("/questions/{questionId}/chosenAnswers")
    public List<ChosenAnswer> getAllChosenAnswer(@PathVariable Long questionId) {
        return answerService.getAllChosenAnswerByQuestionId(questionId);
    }
}
