package com.piggyback.controller;

import com.piggyback.model.User;
import com.piggyback.repository.UserRepository;
import com.piggyback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public User register(@RequestBody User user) {
        UserRepository userRepository = userService.getUserRepository();
        return userRepository.save(user);
    }
}
