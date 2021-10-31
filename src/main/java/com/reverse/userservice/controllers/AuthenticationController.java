package com.reverse.userservice.controllers;

import com.reverse.userservice.models.Credentials;
import com.reverse.userservice.models.ReverseJWT;
import com.reverse.userservice.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "auth")
@Component("AuthenticationController")
public class AuthenticationController {

    private ValidationService valService;

    @Autowired
    public AuthenticationController(ValidationService valService) {
        this.valService = valService;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> checkLoginCredentials(@RequestBody Credentials loginRequest) {

        try {
            ReverseJWT jwt = this.valService.validateCredentials(loginRequest);
            return ResponseEntity.ok().body(jwt);
        } catch (Exception e) {
            return ResponseEntity.status(401).build();
        }
    }

    @PostMapping(value = "/validate")
    public ResponseEntity validateJwt(@RequestBody ReverseJWT jwt) {

        boolean status = this.valService.validateJwt(jwt);

        if(status) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(401).build();
    }
}
