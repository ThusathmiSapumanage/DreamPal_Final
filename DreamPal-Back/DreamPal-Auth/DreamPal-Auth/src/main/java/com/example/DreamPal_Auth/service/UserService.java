package com.example.DreamPal_Auth.service;

import com.example.DreamPal_Auth.entity.User;
import com.example.DreamPal_Auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    public User findById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User update(User user)
    {
        User existingUser = userRepository.findById(user.getId()).orElse(null);
        if (existingUser != null) {
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            existingUser.setEmail(user.getEmail());
            return userRepository.save(existingUser);
        }
        return null;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}

