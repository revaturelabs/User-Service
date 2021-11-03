package com.reverse.userservice.services;

import com.reverse.userservice.models.Credentials;
import com.reverse.userservice.models.User;

import java.util.List;

public interface UserService {


    List<User> getAllUsers();



    User getUserByUsername(String username);

    void registerNewUser(User user);

    void updateUser(User user);

    public User getUserByID(Integer id);



    public void createNewUser(User newUser);



    public Credentials getUserCredentials(Credentials credentials);
}
