package com.example.DreamPal_Resume.service;

import com.example.DreamPal_Resume.entity.Resume;
import com.example.DreamPal_Resume.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResumeService {
    @Autowired
    private ResumeRepository resumeRepository;

    public Resume save(Resume resume)
    {
        Optional<Resume> exsistingResume = resumeRepository.findByUserId(resume.getUserId());
        exsistingResume.ifPresent(r -> resume.setId(r.getId()));
        return resumeRepository.save(resume);
    }

    public Resume getByUserId(String userId)
    {
        return resumeRepository.findByUserId(userId).orElse(null);
    }
}
