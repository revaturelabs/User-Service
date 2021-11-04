package com.reverse.userservice.repositories;

import com.reverse.userservice.models.Gender;
import lombok.Generated;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Generated
public interface GenderRepository extends JpaRepository<Gender, Long> {
    @Override
    List<Gender> findAll();
}
