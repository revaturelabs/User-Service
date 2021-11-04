package com.reverse.userservice.repositories;

import com.reverse.userservice.models.BranchLocation;
import com.reverse.userservice.models.Gender;
import com.reverse.userservice.models.ProfilePicture;
import com.reverse.userservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

    @Query(value = "SELECT u FROM User u")
    List<User> getAllUsers();

    @Query(value = "SELECT u FROM User u WHERE u.id = :id")
    User getUserByID(@Param("id") Integer id);

    @Query(value = "SELECT u FROM User WHERE u.username = :username")
    User getUserByUsername(@Param("username") String username);

    /**
     *
     * using a native query because JPA does not support INSERT statements. will research a DB independent INSERT method
     */
    @Modifying
    @Query(value = "insert into users (username, email, first_name, last_name, passwrd, date_of_birth, gender, branch, profile_picture)" +
            "values (:username, :email, :first_name, :last_name, :passwrd, :date_of_birth, :gender, :branch, :profile_picture)",
    nativeQuery = true)
    void createNewUser(@Param("username") String username, @Param("email") String email, @Param("first_name") String firstName, @Param("last_name") String lastName,
                       @Param("passwrd") String passwrd, @Param("date_of_birth") Instant dateOfBirth, @Param("gender")Gender gender, @Param("branch") BranchLocation branchLocation, @Param("profile_picture") ProfilePicture profilePicture);

    /**
     * need add'l information from front end regarding update fields in use
     * also, determine put vs. patch at the controller
     */
//    @Modifying
//    @Query()
//    void updateUser(User user);
}
