package com.cesaraugc.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cesaraugc.blog.dto.UserDTO;
import com.cesaraugc.blog.model.Role;
import com.cesaraugc.blog.model.User;
import com.cesaraugc.blog.service.UserService;

@RestController("/users")
@RequestMapping("/users")
public class AuthController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public List<UserDTO> getAll() {
        List<User> users = userService.getAll();
        return UserDTO.converter(users);
    }

    @PostMapping()
    public void saveUser(@RequestBody User user) {
        user.setRole(Role.USER);
        userService.save(user);
    }

}
