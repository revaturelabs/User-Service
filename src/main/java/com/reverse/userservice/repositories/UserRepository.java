package com.reverse.userservice.repositories;

import com.reverse.userservice.models.User;
import lombok.Generated;
import org.springframework.data.jpa.repository.JpaRepository;

@Generated
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
