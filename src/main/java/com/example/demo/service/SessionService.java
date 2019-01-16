package com.example.demo.service;

import com.example.demo.entity.Session;
import com.example.demo.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionService {

    private SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public List<Session> getAll() {
        return this.sessionRepository.findAll();
    }

    public Optional<Session> findOne(Long sessionId) {
        return this.sessionRepository.findById(sessionId);
    }

    public void create(Session session) {
        this.sessionRepository.save(session);
    }

    public Optional<Session> startSession(Long sessionId) {
       return this.sessionRepository.findById(sessionId).map(session -> {
           session.setStarted(true);
           return this.sessionRepository.save(session);
       });
    }

    public Optional<Session> finishSession(Long sessionId) {
        return this.sessionRepository.findById(sessionId).map(session -> {
            session.setFinished(true);
            return this.sessionRepository.save(session);
        });
    }

    public Optional<Session> getOne(Long sessionId) {
        return this.sessionRepository.findById(sessionId);
    }
}
