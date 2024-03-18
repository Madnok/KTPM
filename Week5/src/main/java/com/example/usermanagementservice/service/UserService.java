package com.example.usermanagementservice.service;

import java.util.List;

import com.example.usermanagementservice.model.User;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Long userId);

    User createUser(User user);

    User updateUser(Long userId, User user);

    void deleteUser(Long userId);
}