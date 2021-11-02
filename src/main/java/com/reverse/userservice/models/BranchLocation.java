package com.reverse.userservice.models;

import javax.persistence.*;

@Table(name = "branch_locations")
@Entity
public class BranchLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}