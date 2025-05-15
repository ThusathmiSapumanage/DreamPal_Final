package com.example.DreamPal_Auth.service;

import com.example.DreamPal_Auth.entity.User;
import com.example.DreamPal_Auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String register(User user) {
        if (userRepo.findByEmail(user.getEmail()).isPresent()) {
            return "EXISTS";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        return "OK";
    }

    public User login(String email, String password) {
        return userRepo.findByEmail(email)
                .filter(user -> passwordEncoder.matches(password, user.getPassword()))
                .orElse(null);
    }

    public User update(User user) {
        return userRepo.findById(user.getId())
                .map(existingUser -> {
                    existingUser.setUsername(user.getUsername());
                    existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
                    existingUser.setEmail(user.getEmail());
                    return userRepo.save(existingUser);
                })
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    public void deleteById(int id) {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
        } else {
            throw new IllegalArgumentException("User not found");
        }
    }

    public Optional<User> findById(int id) {
        return userRepo.findById(id);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public boolean existsByEmail(String email) {
        return userRepo.existsByEmail(email);
    }

    public boolean existsByUsername(String username) {
        return userRepo.existsByUsername(username);
    }
}


