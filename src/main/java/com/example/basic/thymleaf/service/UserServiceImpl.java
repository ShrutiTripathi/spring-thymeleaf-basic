package com.example.basic.thymleaf.service;

import com.example.basic.thymleaf.dao.UserDAO;
import com.example.basic.thymleaf.model.User;
import com.example.basic.thymleaf.model.UserCreationParameters;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO repository;

    public UserServiceImpl(UserDAO repository) {
        this.repository = repository;
    }

    @Override
    public User createUser(UserCreationParameters parameters) {
        User user = new User(parameters.getGivenName(), parameters.getFamilyName());
        return repository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return repository.findAll();
    }
}