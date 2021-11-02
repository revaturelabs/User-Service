package com.reverse.userservice.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "branch_locations")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class BranchLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "branch_name", nullable = false, length = 50)
    private String branchName;

    @Column(name = "city", nullable = false, length = 50)
    private String city;

    @Column(name = "state", nullable = false, length = 50)
    private String state;

    @Column(name = "country", nullable = false, length = 50)
    private String country;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BranchLocation)) return false;
        BranchLocation that = (BranchLocation) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getBranchName(), that.getBranchName()) && Objects.equals(getCity(), that.getCity()) && Objects.equals(getState(), that.getState()) && Objects.equals(getCountry(), that.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBranchName(), getCity(), getState(), getCountry());
    }
}
