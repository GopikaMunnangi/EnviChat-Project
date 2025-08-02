package com.envnetwork.backend.service;

import com.envnetwork.model.User;
import com.envnetwork.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String registerUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            return "Email already exists!";
        }
        userRepository.save(user);
        return "User registered successfully!";
    }
    public User getUserById(Long id) {
    	return userRepository.findById(id).orElse(null);
    }
}
