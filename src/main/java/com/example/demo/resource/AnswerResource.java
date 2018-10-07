package com.example.demo.resource;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.demo.entity.Answer;
import com.example.demo.service.AnswerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnswerResource {

    private AnswerService answerService;

    public AnswerResource (AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping("/answers")
    public List<Answer> getAll() {
        return answerService.getAll();
    }

    @PostMapping("/answers")
    public void create(@RequestBody Answer answer) {
        answerService.create(answer);
    }
}
