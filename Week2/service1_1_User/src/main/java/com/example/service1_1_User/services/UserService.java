package com.example.service1_1_User.services;

import com.example.service1_1_User.models.User;
import com.example.service1_1_User.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getListUser(){
        return userRepository.findAll();
    }
    public User getUserById(long id){
        return userRepository.findById(id).get();
    }
}
