package com.reverse.userservice.services;

import com.reverse.userservice.models.Credentials;
import com.reverse.userservice.models.ReverseJWT;
import com.reverse.userservice.repositories.MockUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component("ValidationService")
public class ValidationServiceImpl implements ValidationService{

    private MockUserRepo userRepo;

    @Value("${SECRET_KEY}")
    private String secret;

    @Autowired
    public ValidationServiceImpl(MockUserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Override
    public ReverseJWT validateCredentials(Credentials loginRequest) throws Exception {
        Credentials queryCred = this.userRepo.getUser();

        if(loginRequest.getUser_name().equals(queryCred.getUser_name())) {
            if(BCrypt.checkpw(loginRequest.getUser_password(), queryCred.getUser_password())) {
                return new ReverseJWT(10, this.secret);
            }
        }

        throw new Exception("Invalid Credentials");
    }

    @Override
    public boolean validateJwt(ReverseJWT jwt) {
        Integer userId = jwt.getUserID(secret);

        if(userId != null) {
            return true;
        }
        return false;
    }
}
