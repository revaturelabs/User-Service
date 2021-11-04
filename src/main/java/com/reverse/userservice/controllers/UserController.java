package com.reverse.userservice.controllers;

import com.reverse.userservice.controllers.postobjects.UserEdit;
import com.reverse.userservice.models.Credentials;
import com.reverse.userservice.models.ReverseJWT;
import com.reverse.userservice.models.User;
import com.reverse.userservice.services.UserService;
import com.reverse.userservice.services.ValidationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "users")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    //@Qualifier("validationServiceImpl")
    @Autowired
    @Setter
    private ValidationService valService;

    @Autowired
    @Setter
    private UserService userService;

    /**
     * createUser*/
    @PostMapping(path = "/createUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createUser(@RequestBody User user) {
        System.out.println("Controller is on");
        logger.debug("Begin createUser");

        userService.createNewUser(user);

        logger.debug("End createUser successfully");
        return new ResponseEntity(HttpStatus.CREATED);
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

	@PostMapping(path = "/editUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity editUser(@RequestBody UserEdit userEdit) {
        logger.debug("Start editUser");

        ReverseJWT reverseJWT = userEdit.getReverseJWT();
        User user = userEdit.getUser();

        if (!(valService.validateJwt(reverseJWT, user.getId()))) {
            logger.warn("Bad JWT in editUser");
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
        if (userService.getUserByID(user.getId()) != null) {
            userService.updateUser(user);
            logger.debug("End editUser successfully");
            return new ResponseEntity(HttpStatus.CREATED);
        } else {
            logger.warn("User not found in editUser");
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping(path = "/getUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserByID(@RequestBody Long userID) {
        logger.debug("Start getUserByID");
        User user = userService.getUserByID(userID);
        if (user != null) {
            logger.debug("End getUserByID successfully");
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            logger.debug("End getUserByID user not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * @Author: Alberto Figallo
     * */
    @PatchMapping(path = "/updateUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateUser(@RequestBody User user) {
        logger.debug("Begin updateUser");
        List<String> availableFields = Arrays.asList("username","email","firstName","lastName","password","dateOfBirth","gender","branch","profilePicture");
        User userData = userService.getUserByID(user.getId());

        if (userData != null) {
            User updUser = userData;
            for (String field : availableFields) {
                switch (field){
                    case "username": if (user.getUsername() != null) updUser.setUsername(user.getUsername()); break;
                    case "email": if (user.getEmail() != null) updUser.setEmail(user.getEmail()); break;
                    case "firstName": if (user.getFirstName() != null) updUser.setFirstName(user.getFirstName()); break;
                    case "lastName": if (user.getLastName() != null) updUser.setLastName(user.getLastName()); break;
                    case "password": if (user.getPassword() != null) updUser.setPassword(user.getPassword()); break;
                    case "dateOfBirth": if (user.getDateOfBirth() != null) updUser.setDateOfBirth(user.getDateOfBirth()); break;
                    case "gender": if (user.getGender() != null) updUser.setGender(user.getGender()); break;
                    case "branch": if (user.getBranch() != null) user.setBranch(user.getBranch()); break;
                    case "profilePicture": if (user.getProfilePicture() != null) user.setProfilePicture(user.getProfilePicture()); break;
                }
            }
            userService.updateUser(updUser);
            logger.debug("End updateUser Successful!");
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
