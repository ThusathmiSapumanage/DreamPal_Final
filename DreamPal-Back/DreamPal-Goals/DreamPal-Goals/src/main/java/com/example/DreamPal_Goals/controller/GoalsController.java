package com.example.DreamPal_Goals.controller;

import com.example.DreamPal_Goals.entity.Goal;
import com.example.DreamPal_Goals.service.GoalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/goals")
public class GoalsController {
    @Autowired
    private GoalsService goalsService;

    @PostMapping
    public Goal add(@RequestBody Goal goal) {
        return goalsService.createGoal(goal);
    }

    @GetMapping("users/{userId}")
    public List<Goal> get(@PathVariable String userId) {
        return goalsService.getGoalsById(userId);
    }

    @PutMapping("/done/{id}")
    public Goal markDone(@PathVariable String id) {
        return goalsService.markDone(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        goalsService.deleteGoal(id);
    }
}
