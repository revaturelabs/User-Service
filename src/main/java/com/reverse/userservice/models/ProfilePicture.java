package com.reverse.userservice.models;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "profile_pictures")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProfilePicture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "image_location", nullable = false)
    private ImageLocation imageLocation;

    @Column(name = "image_name", nullable = false, length = 50)
    private String imageName;

    @Override
    @Generated
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProfilePicture)) return false;
        ProfilePicture that = (ProfilePicture) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getImageLocation(), that.getImageLocation()) && Objects.equals(getImageName(), that.getImageName());
    }

    @Override
    @Generated
    public int hashCode() {
        return Objects.hash(getId(), getImageLocation(), getImageName());
    }
}
