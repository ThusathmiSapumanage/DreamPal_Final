package com.example.DreamPal_Goals.repository;

import com.example.DreamPal_Goals.entity.Goal;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface GoalsRepository extends MongoRepository<Goal, String> {
    List<Goal> findByUserId(String userId);
}
