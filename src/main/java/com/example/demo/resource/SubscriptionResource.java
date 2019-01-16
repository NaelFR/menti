package com.example.demo.resource;

import com.example.demo.entity.Subscription;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@CrossOrigin
@RestController("/subscribe")
public class SubscriptionResource {

    @PostMapping
    public ResponseEntity<Subscription> create(@Valid @RequestBody Subscription subscription) {
        return ResponseEntity.ok(subscription);
    }
}
