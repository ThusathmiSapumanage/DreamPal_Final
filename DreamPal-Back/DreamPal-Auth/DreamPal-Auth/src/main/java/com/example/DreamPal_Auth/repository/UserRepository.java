package com.example.DreamPal_Auth.repository;

import java.util.Optional;
import com.example.DreamPal_Auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
    Optional<User> findById(int id);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
}
