package com.reverse.userservice.repositories;

import com.reverse.userservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer> {


}
