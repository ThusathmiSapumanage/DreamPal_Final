package com.example.DreamPal_Resume.controller;

import com.example.DreamPal_Resume.entity.Resume;
import com.example.DreamPal_Resume.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/resume")
public class ResumeController {
    @Autowired
    private ResumeService resumeService;

    @PostMapping
    public void saveResume(@RequestBody Resume resume)
    {
        resumeService.save(resume);
    }

    @GetMapping("/{userId}")
    public Resume getResume(@PathVariable String userId)
    {
        return resumeService.getByUserId(userId);
    }
}
