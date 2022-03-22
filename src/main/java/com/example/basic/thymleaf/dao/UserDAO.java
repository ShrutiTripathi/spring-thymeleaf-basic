package com.example.basic.thymleaf.dao;

import com.example.basic.thymleaf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {
}