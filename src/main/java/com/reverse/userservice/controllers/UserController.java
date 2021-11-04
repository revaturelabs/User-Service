package com.reverse.userservice.controllers;


import com.reverse.userservice.models.Credentials;
import com.reverse.userservice.models.ReverseJWT;
import com.reverse.userservice.models.User;
import com.reverse.userservice.services.ValidationService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "user")
public class UserController {

    @Autowired
    @Setter
    private ValidationService validationService;

    /**
     * createUser*/
    @PostMapping("/users/createUser")
    public ResponseEntity createUser(@RequestBody User user) {
        return null;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> checkLoginCredentials(@RequestBody Credentials loginRequest) {

        try {
            ReverseJWT jwt = this.validationService.validateCredentials(loginRequest);
            return ResponseEntity.ok().body(jwt);
        } catch (Exception e) {
            return ResponseEntity.status(401).build();
        }
    }

    @PostMapping(value = "/validate")
    public ResponseEntity validateJwt(@RequestBody ReverseJWT jwt) {

        boolean status = this.validationService.validateJwt(jwt);

        if(status) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(401).build();
    }


}
