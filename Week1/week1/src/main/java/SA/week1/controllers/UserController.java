package SA.week1.controllers;

import SA.week1.models.User;
import SA.week1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/users")
    List<User> getListUser(){
        return userRepository.findAll();
    }
    @GetMapping("/users/{id}")
    User getUserById(@PathVariable long id){
        return userRepository.findById(id).get();
    }
}
