package com.envnetwork.backend.controller;

import com.envnetwork.model.User;
import com.envnetwork.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        System.out.println(">>> Inside registerUser controller");
        System.out.println(">>> User: " + user.getName() + ", " + user.getEmail());
        return userService.registerUser(user);
    }
    
    @GetMapping("/test")
    public String testApi() {
        return "API is working!";
    }

}
