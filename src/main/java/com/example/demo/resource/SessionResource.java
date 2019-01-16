package com.example.demo.resource;

import com.example.demo.entity.Session;
import com.example.demo.exception.SessionNotFoundException;
import com.example.demo.service.SessionService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class SessionResource {
    private SessionService sessionService;

    public SessionResource(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping("/sessions")
    public List<Session> getAll() {
        return sessionService.getAll();
    }

    @PostMapping("/sessions")
    public void create(@RequestBody Session session) {
        sessionService.create(session);
    }

    @PutMapping("/sessions/{sessionId}/start")
    public ResponseEntity<Session> startSession(@PathVariable Long sessionId) {
        return sessionService.startSession(sessionId)
                .map(session -> ResponseEntity.ok().body(session))
                .orElseThrow(SessionNotFoundException::new);
    }

    @PutMapping("/sessions/{sessionId}/finish")
    public ResponseEntity<Session> finishSession(@PathVariable Long sessionId) {
        return sessionService.finishSession(sessionId)
                .map(session -> ResponseEntity.ok().body(session))
                .orElseThrow(SessionNotFoundException::new);
    }

    @GetMapping("/sessions/{sessionId}")
    public ResponseEntity<Session> getOne(@PathVariable Long sessionId) {
        return sessionService.getOne(sessionId)
                .map(session -> ResponseEntity.ok().body(session))
                .orElseThrow(SessionNotFoundException::new);
    }

}
