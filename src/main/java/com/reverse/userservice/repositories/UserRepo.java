package com.reverse.userservice.repositories;

import com.reverse.userservice.models.User;
import org.springframework.stereotype.Component;

@Component("UserRepo")
public interface UserRepo {

    public boolean getUserExists(int userID);
    public boolean getUserExists(String username);

    public User getUserByID(int userID);
    public User getUserByUsername(String username);
}
