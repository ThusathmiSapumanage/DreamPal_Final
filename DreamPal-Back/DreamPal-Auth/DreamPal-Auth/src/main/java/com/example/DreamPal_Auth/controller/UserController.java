package com.example.DreamPal_Auth.controller;

import com.example.DreamPal_Auth.entity.User;
import com.example.DreamPal_Auth.repository.UserRepository;
import com.example.DreamPal_Auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRepository userRepo;


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userRepo.existsByEmail(user.getEmail())) {
            return ResponseEntity.badRequest().body("Email already registered");
        }

        if (userRepo.existsByUsername(user.getUsername())) {
            return ResponseEntity.badRequest().body("Username already taken");
        }

        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);
        return ResponseEntity.ok("User registered");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User request) {
        return userRepo.findByEmail(request.getEmail())
                .map(user -> {
                    if (encoder.matches(request.getPassword(), user.getPassword())) {
                        return ResponseEntity.ok(user);
                    } else {
                        return ResponseEntity.status(401).body("Invalid password");
                    }
                })
                .orElseGet(() -> ResponseEntity.status(404).body("User not found"));
    }

    @PutMapping("/update")
    public User updateUser(User user) {
        return userService.update(user);
    }

    @DeleteMapping("/delete")
    public void deleteUser(int id) {
        userService.deleteById(id);
    }

    @GetMapping("/getUser")
    public User getUser(int id) {
        return userService.findById(id);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.findAll();
    }
}
