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
import java.util.Optional;

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
        System.out.println("User Service is On");
        Optional<User> user = this.userRepository.findById(id);

        if(user.isPresent()){
            return user.get();
        } else {
            return null;
        }

    }

    @Override
    public User getUserByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void createNewUser(User newUser) {
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
