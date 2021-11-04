package com.reverse.userservice.controllers;

import com.reverse.userservice.models.Credentials;
import com.reverse.userservice.models.ReverseJWT;
import com.reverse.userservice.services.ValidationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

public class AuthenticationControllerTest {

    private UserController testAuthController;
    private ValidationService mockValService;       // Will hold the mocked ValidationService.

    @BeforeEach
    public void init() {
        mockValService = mock(ValidationService.class);     // Give mockValService a mocked ValidationService.
        testAuthController = new UserController();          // Can use the mock like any other class
        testAuthController.setValidationService(mockValService);
    }

    @Test
    public void checkLoginCredentialsSucceedTest() throws Exception {
        Credentials mockCredentials = mock(Credentials.class);      // Creating a mock Credentials object.
        ReverseJWT mockReverseJWT = mock(ReverseJWT.class);         // Creating a mock ReverseJWT object.

        /* When the mockValService object receives a call to its validateCredentials function with the mockCredentials object as an argument,
           it will return the mockReverseJWT object. This will be used at this line:
            ReverseJWT jwt = this.valService.validateCredentials(loginRequest);*/
        when(mockValService.validateCredentials(mockCredentials)).thenReturn(mockReverseJWT);

        // Runs the function being tested with the mockCredentials object.
        ResponseEntity testResponseEntity = testAuthController.checkLoginCredentials(mockCredentials);

        /* Asserts that mockValService's validateCredentials function was called with an argument of mockCredentials. The
           test will fail if this has not happened. Not really needed in this case, but I'm putting it in as an example. */
        verify(mockValService).validateCredentials(mockCredentials);

        // Checks that the mocked ReverseJWT was placed in the body of the returned ResponseEntity.
        assertSame(mockReverseJWT, testResponseEntity.getBody(), "MockReverseJWT not returned!");
    }

    @Test
    public void checkLoginCredentialsFailTest() throws Exception {
        Credentials mockCredentials = mock(Credentials.class);
        Exception mockException = mock(Exception.class);

        // This time, when validateCredentials is called with mockCredentials, we'll throw an exception.
        when(mockValService.validateCredentials(mockCredentials)).thenThrow(mockException);

        ResponseEntity testResponseEntity = testAuthController.checkLoginCredentials(mockCredentials);

        assertEquals(401, testResponseEntity.getStatusCodeValue(), "TestResponseEntity status not 401!");
    }
}
