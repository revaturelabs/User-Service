package com.reverse.userservice.models;

import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "image_locations")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class ImageLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "url", nullable = false, length = 200)
    private String url;

    @Override
    @Generated // This generated tag keeps these lines of code from being counting towards/against test coverage
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ImageLocation)) return false;
        ImageLocation that = (ImageLocation) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getUrl(), that.getUrl());
    }

    @Override
    @Generated // This generated tag keeps these lines of code from being counting towards/against test coverage
    public int hashCode() {
        return Objects.hash(getId(), getUrl());
    }
}
