package com.reverse.userservice.services;

import com.reverse.userservice.models.BranchLocation;
import com.reverse.userservice.models.Gender;
import com.reverse.userservice.repositories.BranchLocationRepository;
import com.reverse.userservice.repositories.GenderRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InHouseVariablesService {

    @Autowired
    @Setter
    private GenderRepository genderRepository;

    @Autowired
    @Setter
    private BranchLocationRepository locationRepository;

    /**
     *
     * @return the full list of gender values from the genders table to populate a front end menu
     */
    public List<Gender> getAllGenders(){
        return genderRepository.findAll();
    }

    /**
     *
     * @return the full list of branch locations from the branch_locations to populate a front end menu
     */
    public List<BranchLocation> getAllLocations(){
        return locationRepository.findAll();
    }
}
