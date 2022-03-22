package com.example.basic.thymleaf.service;

import com.example.basic.thymleaf.model.User;
import com.example.basic.thymleaf.model.UserCreationParameters;

import java.util.List;

public interface UserService {
    User createUser(UserCreationParameters parameters);

    List<User> getUsers();
}