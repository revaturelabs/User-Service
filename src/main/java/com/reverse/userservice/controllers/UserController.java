package com.reverse.userservice.controllers;

import com.reverse.userservice.models.User;
import com.reverse.userservice.services.UserService;
import com.reverse.userservice.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "user")
@Component("UserController")
public class UserController {

    private ValidationService valService;

    @Autowired
    public UserController(@Qualifier("validationServiceImpl") ValidationService valService) {
        this.valService = valService;
    }

    /**
     * createUser*/
    @PostMapping("/users/createUser")
    public ResponseEntity createUser(@RequestBody User user) {
        /*try {
            User _user = userRepository
                    .save(new User(user.getUsername(), user.getPassword(), user.getEmail(), user.getUserLevel()));
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }*/
        return null;
    }



}
