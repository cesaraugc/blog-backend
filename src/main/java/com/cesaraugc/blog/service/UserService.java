package com.cesaraugc.blog.service;

import java.util.List;

import com.cesaraugc.blog.model.User;

public interface UserService {
    List<User> getAll();

    void save(User user);
}
