package com.example.Service3_User.repositories;

import com.example.Service3_User.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
