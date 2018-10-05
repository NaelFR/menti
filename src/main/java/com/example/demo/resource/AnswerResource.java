package com.example.demo.resource;

import com.example.demo.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnswerResource {

    private AnswerService answerService;

    public AnswerResource (AnswerService answerService) {
        this.answerService = answerService;
    }

    @RequestMapping("/answers")
    public List<String> getAll() {
        return answerService.getAll();
    }

    @RequestMapping(value = "/answers", method = RequestMethod.POST)
    public void create(@RequestBody String answer) {
        answerService.create(answer);
    }
}
