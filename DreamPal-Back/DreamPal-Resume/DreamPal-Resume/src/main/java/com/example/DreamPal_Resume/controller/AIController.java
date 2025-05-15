package com.example.DreamPal_Resume.controller;

import com.example.DreamPal_Resume.entity.AIRequest;
import com.example.DreamPal_Resume.entity.AIResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@RequestMapping("/ai")
@CrossOrigin(origins = "http://localhost:5173")
public class AIController {

    @Value("${gemini.api.key}")
    private String geminiApiKey;

    private static final String GEMINI_API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent";

    @PostMapping("/improve")
    public ResponseEntity<AIResponse> improveResume(@RequestBody AIRequest request) {
        String prompt = "Please professionally improve this resume:\n\n" + request.getPrompt();
        String aiResponse = callGemini(prompt);
        return ResponseEntity.ok(new AIResponse(aiResponse));
    }

    private String callGemini(String prompt) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Prepare the request structure
        Map<String, String> part = new HashMap<>();
        part.put("text", prompt);

        Map<String, Object> content = new HashMap<>();
        content.put("role", "user");
        content.put("parts", List.of(part));

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("contents", List.of(content));

        String url = "https://generativelanguage.googleapis.com/v1/models/gemini-pro:generateContent?key=" + geminiApiKey;
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        try {
            ResponseEntity<Map> response = restTemplate.postForEntity(url, entity, Map.class);
            List<Map<String, Object>> candidates = (List<Map<String, Object>>) response.getBody().get("candidates");

            if (candidates != null && !candidates.isEmpty()) {
                Map<String, Object> candidate = candidates.get(0);
                Map<String, Object> contentMap = (Map<String, Object>) candidate.get("content");
                List<Map<String, String>> parts = (List<Map<String, String>>) contentMap.get("parts");

                return parts.get(0).get("text");
            } else {
                return "⚠️ Gemini Error: No response candidates returned.";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "⚠️ Gemini Error: " + e.getMessage();
        }
    }

}
