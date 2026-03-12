package com.notes.notesreaderauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String loginPage() {
        return "Welcome to Notes Reader SaaS. Login using Google.";
    }

    @GetMapping("/home")
    public String home() {
        return "Login successful. Welcome to your Notes Reader dashboard.";
    }
}