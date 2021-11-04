package com.reverse.userservice.services;

import com.reverse.userservice.models.Credentials;
import com.reverse.userservice.models.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("UserService")
public interface UserService {

    /**
     * Gets all Users
     * @return A list of all users accessable by the UserService
     */
    List<User> getAllUsers();

    /**
     * Gets the user with the input username.
     * @param username The username to be found.
     * @return The user with the correct username, null if does not exist.
     */
    User getUserByUsername(String username);

    /**
     * Registers a new User.
     * @param user The new User to be registered.
     */
    void registerNewUser(User user);

    /**
     * Updates an existing user.
     * @param user The new User object after updating.
     */
    void updateUser(User user);

    /**
     * Gets the User with the input id.
     * @param id The id of the correct User.
     * @return The User with the correct id, null if not found.
     */
    public User getUserByID(Long id);

    /**     TODO - Either this or registerNewUser needs to be deleted.
     * Creates a new User.
     * @param newUser The new user to be created.
     */
    public void createNewUser(User newUser);

    /**
     * Finds the User referenced in the credentials and returns their correct credentials.
     * @param credentials The input credentials.
     * @return The accurate credentials.
     */
    public Credentials getUserCredentials(Credentials credentials);
}
