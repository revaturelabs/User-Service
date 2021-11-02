package com.reverse.userservice.services;

import com.reverse.userservice.models.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserByID(Integer id);

    User getUserByUsername(String username);

    void registerNewUser(User user);

    void updateUser(User user);

}
