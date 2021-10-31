package com.reverse.userservice.services;


import com.reverse.userservice.models.Credentials;
import com.reverse.userservice.models.ReverseJWT;

public interface ValidationService {

    void setSecret(String secret);

    ReverseJWT validateCredentials(Credentials loginRequest) throws Exception;

    boolean validateJwt(ReverseJWT jwt);
}
