package com.reverse.userservice.controllers;

import com.reverse.userservice.models.BranchLocation;
import com.reverse.userservice.models.Gender;
import com.reverse.userservice.repositories.BranchLocationRepository;
import com.reverse.userservice.repositories.GenderRepository;
import com.reverse.userservice.services.InHouseVariablesService;
import lombok.Setter;
import org.dom4j.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.List;

@RequestMapping(path = "lists")
@RestController
public class GetInHouseVariablesController {

    @Autowired
    @Setter
    private InHouseVariablesService service;

    @GetMapping(value = "/genders")
    public ResponseEntity<List<Gender>> getAllGenders(){
        List<Gender> genderList = this.service.getAllGenders();
        return ResponseEntity.ok().body(genderList);
    }

    @GetMapping(value = "/locations")
    public ResponseEntity<List<BranchLocation>> getAllLocations(){
        List<BranchLocation> locations = this.service.getAllLocations();
        return ResponseEntity.ok().body(locations);
    }

}
