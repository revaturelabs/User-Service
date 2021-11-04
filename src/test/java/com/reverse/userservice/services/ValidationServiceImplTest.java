package com.reverse.userservice.services;

import com.reverse.userservice.models.Credentials;
import com.reverse.userservice.models.ReverseJWT;
import com.reverse.userservice.repositories.MockUserRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {ValidationServiceImpl.class, String.class})
@ExtendWith(SpringExtension.class)
class ValidationServiceImplTest {

    @MockBean(name = "MockUserRepo")
    private MockUserRepo mockUserRepo;

    @Autowired
    private ValidationServiceImpl validationServiceImpl;

    @Test
    void testValidateCredentials() throws Exception {
        when(this.mockUserRepo.getUser())
                .thenReturn(new Credentials("com.reverse.userservice.models.Credentials", "iloveyou"));
        assertThrows(Exception.class,
                () -> this.validationServiceImpl.validateCredentials(new Credentials("User name", "iloveyou")));
        verify(this.mockUserRepo).getUser();
    }

    @Test
    void testValidateCredentials2() throws Exception {
        Credentials credentials = mock(Credentials.class);
        when(credentials.getUser_name()).thenReturn("User name");
        when(this.mockUserRepo.getUser()).thenReturn(credentials);
        assertThrows(Exception.class, () -> this.validationServiceImpl
                .validateCredentials(new Credentials("com.reverse.userservice.models.Credentials", "iloveyou")));
        verify(this.mockUserRepo).getUser();
        verify(credentials).getUser_name();
    }

    @Test
    void testValidateCredentials3() throws Exception {
        Credentials credentials = mock(Credentials.class);
        when(credentials.getUser_name()).thenReturn("User name");
        when(this.mockUserRepo.getUser()).thenReturn(credentials);
        Credentials credentials1 = mock(Credentials.class);
        when(credentials1.getUser_password()).thenReturn("");
        when(credentials1.getUser_name()).thenReturn("foo");
        assertThrows(Exception.class, () -> this.validationServiceImpl.validateCredentials(credentials1));
        verify(this.mockUserRepo).getUser();
        verify(credentials).getUser_name();
        verify(credentials1).getUser_name();
    }

    @Test
    void testValidateJwt() {
        ReverseJWT reverseJWT = mock(ReverseJWT.class);
        when(reverseJWT.getUserID((String) any())).thenReturn(1);
        assertTrue(this.validationServiceImpl.validateJwt(reverseJWT));
        verify(reverseJWT).getUserID((String) any());
    }

    @Test
    void testValidateJwt2() {
        ReverseJWT reverseJWT = mock(ReverseJWT.class);
        when(reverseJWT.getUserID((String) any())).thenReturn(null);
        assertFalse(this.validationServiceImpl.validateJwt(reverseJWT));
        verify(reverseJWT).getUserID((String) any());
    }

    @Test
    void testValidateJwt3() {
        ReverseJWT reverseJWT = mock(ReverseJWT.class);
        when(reverseJWT.getUserID((String) any())).thenReturn(1);
        assertTrue(this.validationServiceImpl.validateJwt(reverseJWT, 1));
        verify(reverseJWT).getUserID((String) any());
    }

    @Test
    void testValidateJwt4() {
        ReverseJWT reverseJWT = mock(ReverseJWT.class);
        when(reverseJWT.getUserID((String) any())).thenReturn(0);
        assertFalse(this.validationServiceImpl.validateJwt(reverseJWT, 1));
        verify(reverseJWT).getUserID((String) any());
    }

    @Test
    void testValidateJwt5() {
        ReverseJWT reverseJWT = mock(ReverseJWT.class);
        when(reverseJWT.getUserID((String) any())).thenReturn(null);
        assertFalse(this.validationServiceImpl.validateJwt(reverseJWT, 1));
        verify(reverseJWT).getUserID((String) any());
    }
}

