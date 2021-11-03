package com.reverse.userservice.services;

import com.reverse.userservice.models.Credentials;
import com.reverse.userservice.models.User;

import java.util.List;

public interface UserService {
<<<<<<< HEAD

    List<User> getAllUsers();
=======
>>>>>>> 1eab99bbe34af29e996820ce09a58bff15ed59af

    public List<User> getAllUsers();

<<<<<<< HEAD
    User getUserByUsername(String username);

    void registerNewUser(User user);

    void updateUser(User user);
=======
    public User getUserByID(Integer id);
    public User getUserByUsername(String username);
>>>>>>> 1eab99bbe34af29e996820ce09a58bff15ed59af

    public void createNewUser(User newUser);
    public void updateUser(User user);

    public Credentials getUserCredentials(Credentials credentials);
}
