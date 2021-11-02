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
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserFull {

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

    @Column(name = "passwrd", nullable = false, length = 24)
    private String passwrd;

    @Column(name = "date_of_birth", nullable = false)
    private Instant dateOfBirth;

    @ManyToOne(optional = false)
    @JoinColumn(name = "gender", nullable = false)
    private Gender gender;

    @ManyToOne(optional = false)
    @JoinColumn(name = "branch", nullable = false)
    private BranchLocation branch;

    @ManyToOne
    @JoinColumn(name = "profile_picture")
    private ProfilePicture profilePicture;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserFull userFull = (UserFull) o;
        return Objects.equals(getId(), userFull.getId()) && Objects.equals(getUsername(), userFull.getUsername()) && Objects.equals(getEmail(), userFull.getEmail()) && Objects.equals(getFirstName(), userFull.getFirstName()) && Objects.equals(getLastName(), userFull.getLastName()) && Objects.equals(getPasswrd(), userFull.getPasswrd()) && Objects.equals(getDateOfBirth(), userFull.getDateOfBirth()) && Objects.equals(getGender(), userFull.getGender()) && Objects.equals(getBranch(), userFull.getBranch()) && Objects.equals(getProfilePicture(), userFull.getProfilePicture());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getEmail(), getFirstName(), getLastName(), getPasswrd(), getDateOfBirth(), getGender(), getBranch(), getProfilePicture());
    }
}
