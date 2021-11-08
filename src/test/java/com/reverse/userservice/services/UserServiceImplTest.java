package com.reverse.userservice.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.reverse.userservice.models.BranchLocation;
import com.reverse.userservice.models.Gender;
import com.reverse.userservice.models.ImageLocation;
import com.reverse.userservice.models.ProfilePicture;
import com.reverse.userservice.models.User;
import com.reverse.userservice.repositories.UserRepository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserServiceImpl.class})
@ExtendWith(SpringExtension.class)
class UserServiceImplTest {
    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Test
    void testGetUserByID() {
        BranchLocation branchLocation = new BranchLocation();
        branchLocation.setCountry("GB");
        branchLocation.setId(123L);
        branchLocation.setCity("Oxford");
        branchLocation.setBranchName("janedoe/featurebranch");
        branchLocation.setState("MD");

        Gender gender = new Gender();
        gender.setId(123L);
        gender.setGender("Gender");

        ImageLocation imageLocation = new ImageLocation();
        imageLocation.setId(123L);
        imageLocation.setUrl("https://example.org/example");

        ProfilePicture profilePicture = new ProfilePicture();
        profilePicture.setId(123L);
        profilePicture.setImageLocation(imageLocation);
        profilePicture.setImageName("Image Name");

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setUsername("janedoe");
        user.setBranch(branchLocation);
        user.setGender(gender);
        user.setId(123L);
        user.setProfilePicture(profilePicture);
        user.setDateOfBirth(null);
        user.setFirstName("Jane");
        Optional<User> ofResult = Optional.<User>of(user);
        when(this.userRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(user, this.userServiceImpl.getUserByID(123L));
        verify(this.userRepository).findById((Long) any());
    }

    @Test
    void testGetUserByID2() {
        when(this.userRepository.findById((Long) any())).thenReturn(Optional.<User>empty());
        assertNull(this.userServiceImpl.getUserByID(123L));
        verify(this.userRepository).findById((Long) any());
    }

    @Test
    void testGetUserByUsername() {
        BranchLocation branchLocation = new BranchLocation();
        branchLocation.setCountry("GB");
        branchLocation.setId(123L);
        branchLocation.setCity("Oxford");
        branchLocation.setBranchName("janedoe/featurebranch");
        branchLocation.setState("MD");

        Gender gender = new Gender();
        gender.setId(123L);
        gender.setGender("Gender");

        ImageLocation imageLocation = new ImageLocation();
        imageLocation.setId(123L);
        imageLocation.setUrl("https://example.org/example");

        ProfilePicture profilePicture = new ProfilePicture();
        profilePicture.setId(123L);
        profilePicture.setImageLocation(imageLocation);
        profilePicture.setImageName("Image Name");

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setUsername("janedoe");
        user.setBranch(branchLocation);
        user.setGender(gender);
        user.setId(123L);
        user.setProfilePicture(profilePicture);
        user.setDateOfBirth(null);
        user.setFirstName("Jane");
        when(this.userRepository.findByUsername((String) any())).thenReturn(user);
        assertSame(user, this.userServiceImpl.getUserByUsername("janedoe"));
        verify(this.userRepository).findByUsername((String) any());
    }

    @Test
    void testCreateNewUser() {
        BranchLocation branchLocation = new BranchLocation();
        branchLocation.setCountry("GB");
        branchLocation.setId(123L);
        branchLocation.setCity("Oxford");
        branchLocation.setBranchName("janedoe/featurebranch");
        branchLocation.setState("MD");

        Gender gender = new Gender();
        gender.setId(123L);
        gender.setGender("Gender");

        ImageLocation imageLocation = new ImageLocation();
        imageLocation.setId(123L);
        imageLocation.setUrl("https://example.org/example");

        ProfilePicture profilePicture = new ProfilePicture();
        profilePicture.setId(123L);
        profilePicture.setImageLocation(imageLocation);
        profilePicture.setImageName("Image Name");

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setUsername("janedoe");
        user.setBranch(branchLocation);
        user.setGender(gender);
        user.setId(123L);
        user.setProfilePicture(profilePicture);
        user.setDateOfBirth(null);
        user.setFirstName("Jane");
        when(this.userRepository.save((User) any())).thenReturn(user);

        BranchLocation branchLocation1 = new BranchLocation();
        branchLocation1.setCountry("GB");
        branchLocation1.setId(123L);
        branchLocation1.setCity("Oxford");
        branchLocation1.setBranchName("janedoe/featurebranch");
        branchLocation1.setState("MD");

        Gender gender1 = new Gender();
        gender1.setId(123L);
        gender1.setGender("Gender");

        ImageLocation imageLocation1 = new ImageLocation();
        imageLocation1.setId(123L);
        imageLocation1.setUrl("https://example.org/example");

        ProfilePicture profilePicture1 = new ProfilePicture();
        profilePicture1.setId(123L);
        profilePicture1.setImageLocation(imageLocation1);
        profilePicture1.setImageName("Image Name");

        User user1 = new User();
        user1.setLastName("Doe");
        user1.setEmail("jane.doe@example.org");
        user1.setPassword("iloveyou");
        user1.setUsername("janedoe");
        user1.setBranch(branchLocation1);
        user1.setGender(gender1);
        user1.setId(123L);
        user1.setProfilePicture(profilePicture1);
        user1.setDateOfBirth(null);
        user1.setFirstName("Jane");
        assertEquals(123L, this.userServiceImpl.createNewUser(user1).longValue());
        verify(this.userRepository).save((User) any());
    }

    @Test
    void testUpdateUser() {
        BranchLocation branchLocation = new BranchLocation();
        branchLocation.setCountry("GB");
        branchLocation.setId(123L);
        branchLocation.setCity("Oxford");
        branchLocation.setBranchName("janedoe/featurebranch");
        branchLocation.setState("MD");

        Gender gender = new Gender();
        gender.setId(123L);
        gender.setGender("Gender");

        ImageLocation imageLocation = new ImageLocation();
        imageLocation.setId(123L);
        imageLocation.setUrl("https://example.org/example");

        ProfilePicture profilePicture = new ProfilePicture();
        profilePicture.setId(123L);
        profilePicture.setImageLocation(imageLocation);
        profilePicture.setImageName("Image Name");

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setUsername("janedoe");
        user.setBranch(branchLocation);
        user.setGender(gender);
        user.setId(123L);
        user.setProfilePicture(profilePicture);
        user.setDateOfBirth(null);
        user.setFirstName("Jane");
        when(this.userRepository.save((User) any())).thenReturn(user);

        BranchLocation branchLocation1 = new BranchLocation();
        branchLocation1.setCountry("GB");
        branchLocation1.setId(123L);
        branchLocation1.setCity("Oxford");
        branchLocation1.setBranchName("janedoe/featurebranch");
        branchLocation1.setState("MD");

        Gender gender1 = new Gender();
        gender1.setId(123L);
        gender1.setGender("Gender");

        ImageLocation imageLocation1 = new ImageLocation();
        imageLocation1.setId(123L);
        imageLocation1.setUrl("https://example.org/example");

        ProfilePicture profilePicture1 = new ProfilePicture();
        profilePicture1.setId(123L);
        profilePicture1.setImageLocation(imageLocation1);
        profilePicture1.setImageName("Image Name");

        User user1 = new User();
        user1.setLastName("Doe");
        user1.setEmail("jane.doe@example.org");
        user1.setPassword("iloveyou");
        user1.setUsername("janedoe");
        user1.setBranch(branchLocation1);
        user1.setGender(gender1);
        user1.setId(123L);
        user1.setProfilePicture(profilePicture1);
        user1.setDateOfBirth(null);
        user1.setFirstName("Jane");
        this.userServiceImpl.updateUser(user1);
        verify(this.userRepository).save((User) any());
    }

    @Test
    void testConstructor() {
        assertNull((new UserServiceImpl()).getAllUsers());
    }
}

