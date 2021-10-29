package com.reverse.userservice.services;


import com.reverse.userservice.models.Credentials;
import com.reverse.userservice.models.ReverseJWT;

public interface ValidationService {

    ReverseJWT validateCredentials(Credentials loginRequest) throws Exception;
}
