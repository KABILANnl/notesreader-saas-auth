package com.notes.notesreaderauth.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class PaidUser {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String email;

    private String paymentId;

    private String gateway;

    private Instant createdAt = Instant.now();

    public PaidUser() {}

    public PaidUser(String email, String paymentId, String gateway) {
        this.email = email;
        this.paymentId = paymentId;
        this.gateway = gateway;
    }

    public String getEmail() {
        return email;
    }
}