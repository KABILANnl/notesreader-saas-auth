package com.notes.notesreaderauth.repository;

import com.notes.notesreaderauth.entity.PaidUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaidUserRepository extends JpaRepository<PaidUser, String> {

    boolean existsByEmail(String email);

}