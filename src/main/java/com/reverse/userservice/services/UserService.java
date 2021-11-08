package com.reverse.userservice.services;

import com.reverse.userservice.models.User;

import java.util.List;


public interface UserService {

    List<User> getAllUsers();

    User getUserByUsername(String username);

    void updateUser(User user);

    public User getUserByID(Long id);

    Long createNewUser(User newUser);

}
