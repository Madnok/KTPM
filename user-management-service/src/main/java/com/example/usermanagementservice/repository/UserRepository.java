package com.example.usermanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.usermanagementservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // TODO: Add custom queries if needed
}