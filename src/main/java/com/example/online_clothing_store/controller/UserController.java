package com.example.online_clothing_store.controller;

import com.example.online_clothing_store.model.User;
import com.example.online_clothing_store.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/sync")
    public void syncUsers(@RequestBody List<User> users) {
        for (User user : users) {
            userRepository.save(user);
        }
    }
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        user.setId(null);
        return userRepository.save(user);
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User user) {
        user.setId(id);
        return userRepository.save(user);
    }
}
