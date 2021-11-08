package com.reverse.userservice.controllers;

import com.reverse.userservice.services.InHouseVariablesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {GetInHouseVariablesController.class})
@ExtendWith(SpringExtension.class)
class GetInHouseVariablesControllerTest {
    @Autowired
    private GetInHouseVariablesController getInHouseVariablesController;

    @MockBean
    private InHouseVariablesService inHouseVariablesService;

    @Test
    void testGetAllGenders() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/genders");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.getInHouseVariablesController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void testGetAllLocations() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/locations");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.getInHouseVariablesController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}

