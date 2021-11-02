package com.reverse.userservice.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "email", nullable = false, length = 150)
    private String email;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "password", nullable = false, length = 24)
    private String password;

    @Column(name = "date_of_birth", nullable = false)
    private Instant dateOfBirth;

    @ManyToOne(optional = false)
    @JoinColumn(name = "gender", nullable = false)
    private Gender gender;

    @ManyToOne(optional = false)
    @JoinColumn(name = "branch", nullable = false)
    private BranchLocation branch;

    @OneToOne
    @JoinColumn(name = "profile_picture")
    private ProfilePicture profilePicture;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId().equals(user.getId()) && getUsername().equals(user.getUsername()) && getEmail().equals(user.getEmail()) && getFirstName().equals(user.getFirstName()) && getLastName().equals(user.getLastName()) && getPassword().equals(user.getPassword()) && getDateOfBirth().equals(user.getDateOfBirth()) && getGender().equals(user.getGender()) && getBranch().equals(user.getBranch()) && getProfilePicture().equals(user.getProfilePicture());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getEmail(), getFirstName(), getLastName(), getPassword(), getDateOfBirth(), getGender(), getBranch(), getProfilePicture());
    }
}