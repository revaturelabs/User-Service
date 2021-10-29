package com.reverse.userservice.services;

import com.reverse.userservice.models.Credentials;
import com.reverse.userservice.models.ReverseJWT;
import com.reverse.userservice.repositories.MockUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ValidationService")
public class ValidationServiceImpl implements ValidationService{

    private MockUserRepo userRepo;

    private String secret = "g9vcBtznWr+HpLBjBi3IW/cOOd8gjnJYJ32ftiNDpBBPtcHO3ac/4IiK4eCz8x4xlEH0o6E53tS8UVOSQyY+yg==";

    @Autowired
    public ValidationServiceImpl(MockUserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public ReverseJWT validateCredentials(Credentials loginRequest) throws Exception {
        Credentials queryCred = this.userRepo.getUser();

        if(loginRequest.equals(queryCred)) {
            return new ReverseJWT(10, this.secret);
        } else {
            throw new Exception("Invalid Credentials");
        }
    }
}
