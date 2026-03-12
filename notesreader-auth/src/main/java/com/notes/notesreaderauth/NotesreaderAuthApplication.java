package com.notes.notesreaderauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class NotesreaderAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotesreaderAuthApplication.class, args);
	}
}