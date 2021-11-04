package com.reverse.userservice.services;

import com.reverse.userservice.models.BranchLocation;
import com.reverse.userservice.models.Credentials;
import com.reverse.userservice.models.Gender;
import com.reverse.userservice.models.User;
import com.reverse.userservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component("UserServiceImpl")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User getUserByID(Long id) {
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        return null;
    }

    @Override
    public void createNewUser(User newUser) {
        System.out.println("User Service is on");
        this.userRepository.save(newUser);
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public Credentials getUserCredentials(Credentials credentials) {
        return null;
    }
}
