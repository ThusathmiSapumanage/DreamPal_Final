package com.example.DreamPal_Resume.controller;

import com.example.DreamPal_Resume.entity.AIResponse;
import com.example.DreamPal_Resume.entity.APIRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ai")
@CrossOrigin(origins = "http://localhost:5173")
public class APIController {
    @PostMapping("/improve")
    public ResponseEntity<AIResponse> improveResume(@RequestBody AIRequest request) {
        // TEMP: Replace this with real OpenAI call later
        String improvedResume = request.getPrompt().toUpperCase(); // Fake "AI" improvement
        return ResponseEntity.ok(new AIResponse(improvedResume));
    }
}
