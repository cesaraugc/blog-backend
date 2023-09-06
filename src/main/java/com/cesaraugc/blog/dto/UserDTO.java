package com.cesaraugc.blog.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.cesaraugc.blog.model.Role;
import com.cesaraugc.blog.model.User;

public class UserDTO {
    public long id;
    public String username;
    public Role role;

    public UserDTO(User user) {
        id = user.getId();
        username = user.getUsername();
        role = user.getRole();
    }

    public static List<UserDTO> converter(List<User> users) {
        return users.stream().map(UserDTO::new).collect(Collectors.toList());
    }
}
