package com.reverse.userservice.services;

import com.reverse.userservice.models.Credentials;
import com.reverse.userservice.models.User;

import java.util.List;
import java.util.Optional;


public interface UserService {

    List<User> getAllUsers();

    User getUserByUsername(String username);

    void updateUser(User user);

    public User getUserByID(Long id);

    void createNewUser(User newUser);

    public Credentials getUserCredentials(Credentials credentials);
}
