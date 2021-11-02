package com.reverse.userservice.controllers;

import com.reverse.userservice.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "user")
@Component("UserController")
public class UserController {

    @Autowired
    private ValidationService validationService;

    @Autowired
    public UserController(ValidationService valService) {
        this.validationService = valService;
    }
}
