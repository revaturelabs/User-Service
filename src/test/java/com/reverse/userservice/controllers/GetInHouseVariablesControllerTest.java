package com.reverse.userservice.controllers;

import com.reverse.userservice.models.BranchLocation;
import com.reverse.userservice.models.Gender;
import com.reverse.userservice.repositories.BranchLocationRepository;
import com.reverse.userservice.repositories.GenderRepository;
import com.reverse.userservice.services.InHouseVariablesService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class GetInHouseVariablesControllerTest {

    static Gender gender1;
    static Gender gender2;
    static List<Gender> genderList;
    static GenderRepository mockGenderRepository;

    static BranchLocation location1;
    static BranchLocation location2;
    static List<BranchLocation> locationList;
    static BranchLocationRepository mockLocationRepository;

    static InHouseVariablesService service;
    static GetInHouseVariablesController controller;

    @BeforeAll
    static void setup(){

        // Create mock genders
        gender1 = new Gender();
        gender2 = new Gender();

        // Create mock gender list
        genderList = new ArrayList<>();
        genderList.add(gender1);
        genderList.add(gender2);

        // Set up mockito to return the mock list when the "find all" method is called
        mockGenderRepository = mock(GenderRepository.class);
        when(mockGenderRepository.findAll()).thenReturn(genderList);

        // Create mock locations
        location1 = new BranchLocation();
        location2 = new BranchLocation();

        // Add mock locations to list
        locationList = new ArrayList<>();
        locationList.add(location1);
        locationList.add(location2);

        // Set up mockito to return the mock list when the "find all" method is called
        mockLocationRepository = mock(BranchLocationRepository.class);
        when(mockLocationRepository.findAll()).thenReturn(locationList);

        // Create service
        service = new InHouseVariablesService();

        // Inject mock repositories
        service.setLocationRepository(mockLocationRepository);
        service.setGenderRepository(mockGenderRepository);

        // Create controller
        controller = new GetInHouseVariablesController();

        // Inject service into the controller
        controller.setService(service);
    }

    @Test
    void getAllGenders() {
        assertNull(controller.getAllGenders());
    }

    @Test
    void getAllLocations() {
        assertNull(controller.getAllLocations());
    }
}