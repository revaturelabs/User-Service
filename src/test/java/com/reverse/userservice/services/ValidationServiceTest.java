package com.reverse.userservice.services;

import com.reverse.userservice.models.Credentials;
import com.reverse.userservice.models.ReverseJWT;
import com.reverse.userservice.models.User;
import com.reverse.userservice.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ValidationServiceTest {

    private String secret = "g9vcBtznWr+HpLBjBi3IW/cOOd8gjnJYJ32ftiNDpBBPtcHO3ac/4IiK4eCz8x4xlEH0o6E53tS8UVOSQyY+yg==";

    private ValidationService validationServiceTest;
    private UserRepository mockRepo;

    @BeforeEach
    public void init() {
        this.mockRepo = mock(UserRepository.class);
        this.validationServiceTest = new ValidationServiceImpl(this.mockRepo);
        this.validationServiceTest.setSecret(this.secret);
    }

    @Test
    public void validateCredentialsTest() throws Exception{
        User user = new User();
        user.setUsername("test");
        user.setPassword("$2a$10$XL3q/vz6yI46hl/6kJQXyuEAQ0B.8tGEjO221CbJlaR.74opT90tW");
        Credentials credentials = new Credentials("test", "test");

        when(mockRepo.findByUsername("test")).thenReturn(user);

        ReverseJWT jwt = validationServiceTest.validateCredentials(credentials);

        assertNotNull(jwt.getToken());
    }

    @Test void validateJwtTest() {
        ReverseJWT jwt = new ReverseJWT(10, this.secret);

        boolean status = this.validationServiceTest.validateJwt(jwt);

        assertTrue(status);
    }
}
