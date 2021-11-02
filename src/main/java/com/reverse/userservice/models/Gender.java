package com.reverse.userservice.models;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="genders")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "gender", nullable = false, length = 16)
    private Gender gender;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gender)) return false;
        Gender gender1 = (Gender) o;
        return Objects.equals(getId(), gender1.getId()) && getGender().equals(gender1.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getGender());
    }
}
