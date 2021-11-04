package com.reverse.userservice.controllers;


import com.reverse.userservice.models.User;
import com.reverse.userservice.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private ValidationService validationService;

    /**
     * createUser*/
    @PostMapping("/users/createUser")
    public ResponseEntity createUser(@RequestBody User user) {
        return null;
    }



}
