package com.example.DreamPal_Resume.repository;

import com.example.DreamPal_Resume.entity.Resume;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ResumeRepository extends MongoRepository<Resume, String> {
    Optional<Resume> findByUserId(String userId);
}
