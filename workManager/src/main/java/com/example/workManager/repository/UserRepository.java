package com.example.workManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.workManager.model.User;
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
