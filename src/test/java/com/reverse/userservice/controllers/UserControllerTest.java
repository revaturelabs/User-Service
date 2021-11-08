package com.reverse.userservice.controllers;

import com.reverse.userservice.controllers.postobjects.UserEdit;
import com.reverse.userservice.models.ReverseJWT;
import com.reverse.userservice.models.User;
import com.reverse.userservice.services.UserService;
import com.reverse.userservice.services.ValidationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    private UserController testUserController;
    private ValidationService mockValidationService;
    private UserService mockUserService;

    @BeforeEach
    public void init() {
        mockValidationService = mock(ValidationService.class);
        mockUserService = mock(UserService.class);
        testUserController = new UserController();
        testUserController.setValService(mockValidationService);
        testUserController.setUserService(mockUserService);
    }

    @Test
    public void createUserTestSuccess() {
        User mockUser = mock(User.class);

        ResponseEntity testResponseEntity = testUserController.createUser(mockUser);

        verify(mockUserService).createNewUser(mockUser);
        assertEquals(HttpStatus.CREATED, testResponseEntity.getStatusCode(), "Incorrect HttpStatus returned!");
    }

    @Test
    public void updateUserTestSuccess() {
        User mockUser = mock(User.class);
        User mockServiceUser = mock(User.class);
        ReverseJWT mockReverseJWT = mock(ReverseJWT.class);
        UserEdit mockUserEdit = mock(UserEdit.class);

        when(mockValidationService.validateJwt(mockReverseJWT, 42)).thenReturn(true);
        when(mockUserService.getUserByID(42L)).thenReturn(mockServiceUser);
        when(mockUser.getId()).thenReturn(42L);
        when(mockUserEdit.getUser()).thenReturn(mockUser);
        when(mockUserEdit.getReverseJWT()).thenReturn(mockReverseJWT);

        ResponseEntity testResponseEntity = testUserController.editUser(mockUserEdit);

        verify(mockUserService).updateUser(mockUser);
        assertEquals(HttpStatus.CREATED, testResponseEntity.getStatusCode(), "Incorrect HttpStatus returned!");
    }

    @Test
    public void updateUserTestFailureJWT() {
        User mockUser = mock(User.class);
        User mockServiceUser = mock(User.class);
        ReverseJWT mockReverseJWT = mock(ReverseJWT.class);
        UserEdit mockUserEdit = mock(UserEdit.class);

        when(mockValidationService.validateJwt(mockReverseJWT, 42)).thenReturn(false);
        when(mockUserService.getUserByID(42L)).thenReturn(mockUser);
        when(mockUser.getId()).thenReturn(42L);
        when(mockUserEdit.getUser()).thenReturn(mockUser);
        when(mockUserEdit.getReverseJWT()).thenReturn(mockReverseJWT);

        ResponseEntity testResponseEntity = testUserController.editUser(mockUserEdit);

        verify(mockUserService, never()).updateUser(mockUser);
        assertEquals(HttpStatus.UNAUTHORIZED, testResponseEntity.getStatusCode(), "Incorrect HttpStatus returned!");
    }

    @Test
    public void updateUserTestFailureNoUser() {
        User mockUser = mock(User.class);
        ReverseJWT mockReverseJWT = mock(ReverseJWT.class);
        UserEdit mockUserEdit = mock(UserEdit.class);

        when(mockValidationService.validateJwt(mockReverseJWT, 42)).thenReturn(true);
        when(mockUserService.getUserByID(42L)).thenReturn(null);
        when(mockUser.getId()).thenReturn(42L);
        when(mockUserEdit.getUser()).thenReturn(mockUser);
        when(mockUserEdit.getReverseJWT()).thenReturn(mockReverseJWT);

        ResponseEntity testResponseEntity = testUserController.editUser(mockUserEdit);

        verify(mockUserService, never()).updateUser(mockUser);
        assertEquals(HttpStatus.UNAUTHORIZED, testResponseEntity.getStatusCode(), "Incorrect HttpStatus returned!");
    }

    @Test
    public void getUserTestSuccess() {
        User mockUser = mock(User.class);

        when(mockUserService.getUserByID(42L)).thenReturn(mockUser);

        ResponseEntity<User> testResponseEntity = testUserController.getUserByID(42L);

        assertSame(mockUser, testResponseEntity.getBody(), "mockUser not in testResponseEntity body!");
        assertEquals(HttpStatus.OK, testResponseEntity.getStatusCode(), "Incorrect HttpStatus returned!");
    }

    @Test
    public void getUserTestFailure() {
        when(mockUserService.getUserByID(42L)).thenReturn(null);

        ResponseEntity<User> testResponseEntity = testUserController.getUserByID(42L);

        assertEquals(HttpStatus.NOT_FOUND, testResponseEntity.getStatusCode(), "Incorrect HttpStatus returned!");
    }

    @Test
    public void updateUser() {
        User mockUser = mock(User.class);
        ResponseEntity testResponseEntity = testUserController.updateUser(mockUser);
        when(mockUserService.getUserByID(42L)).thenReturn(mockUser);
        verify(mockUserService, never()).updateUser(mockUser);
        assertEquals(HttpStatus.NOT_FOUND, testResponseEntity.getStatusCode(), "Incorrect HttpStatus returned!");
    }
}
