package com.example.DreamPal_Goals.service;

import com.example.DreamPal_Goals.entity.Goal;
import com.example.DreamPal_Goals.repository.GoalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalsService {

    @Autowired
    private GoalsRepository goalsRepository;

    public Goal createGoal(Goal Goal) {
        return goalsRepository.save(Goal);
    }

    public List<Goal> getGoalsById(String userId) {
        return goalsRepository.findByUserId(userId);
    }

    public Goal markDone(String id)
    {
        Goal goal = goalsRepository.findById(id).orElseThrow();
        goal.setDone(true);
        return goalsRepository.save(goal);
    }

    public void deleteGoal(String id) {
        goalsRepository.deleteById(id);
    }

    public Goal updateGoal(Goal goal) {
        Goal exGoal = goalsRepository.findById(goal.getId()).orElseThrow();
        exGoal.setTitle(goal.getTitle());
        exGoal.setType(goal.getType());
        exGoal.setDeadline(goal.getDeadline());
        exGoal.setDone(goal.isDone());
        exGoal.setUserId(goal.getUserId());
        return goalsRepository.save(exGoal);
    }
}
