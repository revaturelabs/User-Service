package com.reverse.userservice.controllers;

import com.reverse.userservice.models.BranchLocation;
import com.reverse.userservice.models.Gender;
import com.reverse.userservice.repositories.BranchLocationRepository;
import com.reverse.userservice.repositories.GenderRepository;
import com.reverse.userservice.services.InHouseVariablesService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

@RequestMapping(path = "lists")
@RestController
public class GetInHouseVariablesController {

    @Autowired
    @Setter
    private InHouseVariablesService service;

    @GetMapping(value = "/genders")
    public ResponseEntity<Gender> getAllGenders(){
        return null;
    }

    @GetMapping(value = "/locations")
    public ResponseEntity<BranchLocation> getAllLocations(){
        return null;
    }

}
