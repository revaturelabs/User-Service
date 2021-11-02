package com.reverse.userservice.services;

import com.reverse.userservice.models.Credentials;
import com.reverse.userservice.models.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public User getUserByID(Integer id);
    public User getUserByUsername(String username);

    public void createNewUser(User newUser);
    public void updateUser(User user);

    public Credentials getUserCredentials(Credentials credentials);
}
