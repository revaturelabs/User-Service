package com.reverse.userservice.services;

import com.reverse.userservice.models.Credentials;
import com.reverse.userservice.models.ReverseJWT;
import com.reverse.userservice.models.User;
import com.reverse.userservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component("ValidationService")
public class ValidationServiceImpl implements ValidationService{

    private UserRepository userRepo;

    @Value("${SECRET_KEY}")
    private String secret;

    @Autowired
    public ValidationServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Override
    public ReverseJWT validateCredentials(Credentials loginRequest) throws Exception {

        User query = this.userRepo.findByUsername(loginRequest.getUsername());

        if(query!=null) {
            if(BCrypt.checkpw(loginRequest.getPassword(), query.getPassword())) {
                return new ReverseJWT(query.getId(), this.secret);
            }
        }

        throw new Exception("Invalid Credentials");
    }

    @Override
    public boolean validateJwt(ReverseJWT jwt) {
        Long userId = jwt.getUserID(secret);

        if(userId != null) {
            return true;
        }
        return false;
    }
}
