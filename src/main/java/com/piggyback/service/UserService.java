package com.piggyback.service;

import com.piggyback.model.User;
import com.piggyback.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public Optional<User> getUserById(Integer userId) {
        return userRepository.findById(userId);
    }

//    public User saveUser(User user)
//    {
//        user.setCreatedAt(java.time.LocalDateTime.now());
//        user.setUpdatedAt(java.time.LocalDateTime.now());
//        return userRepository.save(user);
//    }

    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);  // Default method from JpaRepository
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();  // Default method from JpaRepository
    }

    public boolean userExists(Integer userId) {
        return userRepository.existsById(userId);  // Default method from JpaRepository
    }

}
