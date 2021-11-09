package com.reverse.userservice.services;

import com.reverse.userservice.models.User;
import com.reverse.userservice.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {

    private UserServiceImpl testUserServiceImpl;

    private UserRepository mockUserRepository;

    @BeforeEach
    public void init() {
        mockUserRepository = mock(UserRepository.class);
        testUserServiceImpl = new UserServiceImpl();
        testUserServiceImpl.setUserRepository(mockUserRepository);
    }

    @Test
    public void getAllUsersTest() {
        List<User> mockList = mock(List.class);
        when(mockUserRepository.findAll()).thenReturn(mockList);

        List testList = testUserServiceImpl.getAllUsers();

        assertSame(mockList, testList, "mockList not returned!");
    }

    @Test
    public void getUserByIdSuccess() {
        long correctID = 42L;

        User mockUser = mock(User.class);

        Optional<User> testOptional = Optional.of(mockUser);

        when(mockUserRepository.findById(correctID)).thenReturn(testOptional);

        User testUser = testUserServiceImpl.getUserByID(correctID);

        assertSame(mockUser, testUser, "mockUser not returned!");
    }

    @Test
    public void getUserByIdFailure() {
        long correctID = 42L;

        User mockUser = null;
        Optional<User> testOptional = Optional.ofNullable(mockUser);

        when(mockUserRepository.findById(correctID)).thenReturn(testOptional);

        User testUser = testUserServiceImpl.getUserByID(correctID);

        assertNull(testUser, "testUser not null!");
    }

    @Test
    public void getUserByUsernameTest() {
        String username = "username";

        User mockUser = mock(User.class);

        when(mockUserRepository.findByUsername(username)).thenReturn(mockUser);

        User testUser = testUserServiceImpl.getUserByUsername(username);

        assertSame(mockUser, testUser, "mockUser not returned!");
    }

    // Skipping createNewUser due to work being done on it. TODO - Add test

    @Test
    public void updateUser() {
        User mockUser = mock(User.class);

        testUserServiceImpl.updateUser(mockUser);

        verify(mockUserRepository).save(mockUser);
    }
}
