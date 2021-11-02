package com.reverse.userservice.services;

import com.reverse.userservice.models.Credentials;
import com.reverse.userservice.models.ReverseJWT;
import com.reverse.userservice.models.User;
import com.reverse.userservice.repositories.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ValidationServiceTest {

    private String secret = "g9vcBtznWr+HpLBjBi3IW/cOOd8gjnJYJ32ftiNDpBBPtcHO3ac/4IiK4eCz8x4xlEH0o6E53tS8UVOSQyY+yg==";

    private ValidationService validationServiceTest;
    private UserRepo mockRepo;

    @BeforeEach
    public void init() {
        this.mockRepo = mock(UserRepo.class);
        this.validationServiceTest = new ValidationServiceImpl(this.mockRepo);
        this.validationServiceTest.setSecret(this.secret);
    }

    @Test
    public void validateCredentialsTest() throws Exception{
        User mockUser = mock(User.class);
        Credentials mockCred = new Credentials("test", "$2a$10$XL3q/vz6yI46hl/6kJQXyuEAQ0B.8tGEjO221CbJlaR.74opT90tW");
        Credentials credentials = new Credentials("test", "test");

        when(mockRepo.getUserByUsername("test")).thenReturn(mockUser);
        when(mockUser.getCredentials()).thenReturn(mockCred);
        when(mockUser.getUserID()).thenReturn(10);

        ReverseJWT jwt = validationServiceTest.validateCredentials(credentials);

        assertTrue(jwt.getToken() != null, "No jwt recieved!");
        assertEquals(10, jwt.getUserID(secret), "jwt incorrect!");
    }

    @Test void validateJwtTestSuccess() {
        ReverseJWT mockJWT = mock(ReverseJWT.class);
        when(mockJWT.getUserID(secret)).thenReturn(5);

        boolean status = this.validationServiceTest.validateJwt(mockJWT);

        assertTrue(status);
    }

    @Test void validateJwtTestFail() {
        ReverseJWT mockJWT = mock(ReverseJWT.class);
        when(mockJWT.getUserID(secret)).thenReturn(null);

        boolean status = this.validationServiceTest.validateJwt(mockJWT);

        assertFalse(status);
    }
}
