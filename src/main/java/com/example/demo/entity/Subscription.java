package com.example.demo.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class Subscription {
    @Email
    @NotNull
    private String email;

    @NotNull
    private Boolean newsletter;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(Boolean newsletter) {
        this.newsletter = newsletter;
    }
}
