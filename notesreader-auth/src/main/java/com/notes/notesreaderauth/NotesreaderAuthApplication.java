package com.notes.notesreaderauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.notes.notesreaderauth.repository")
public class NotesreaderAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotesreaderAuthApplication.class, args);
	}
}