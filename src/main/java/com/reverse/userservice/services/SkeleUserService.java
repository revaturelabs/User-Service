package com.reverse.userservice.services;

import com.reverse.userservice.models.Credentials;
import com.reverse.userservice.models.User;

import java.util.List;

public class SkeleUserService implements UserService{
    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User getUserByID(Integer id) {
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        return null;
    }

    @Override
    public void registerNewUser(User user) {

    }

    @Override
    public void createNewUser(User newUser) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public Credentials getUserCredentials(Credentials credentials) {
        return null;
    }


}
