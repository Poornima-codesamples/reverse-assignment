package com.assignment.reverse.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.assignment.reverse.exception.CustomizedResponseEntityExceptionHandler;
import com.assignment.reverse.service.ReverseService;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@ContextConfiguration(classes = {ReverseController.class,ReverseService.class,CustomizedResponseEntityExceptionHandler.class})
@WebMvcTest
@AutoConfigureMockMvc
public class ReverseControllerTest {

    @Autowired
    MockMvc mockMvc;
   
    @Test
    public void reverse() throws Exception {
    	
    	mockMvc.perform(MockMvcRequestBuilders.get("/api/reverse/palindrome")
                        .contentType(APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$", is("emordnilap")));
    	
    }

   @Test
    public void clientError() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/reverse/")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }
    
    @Test
    public void validationerror() throws Exception {
       mockMvc.perform(MockMvcRequestBuilders.get("/api/reverse/AB1")
                        .contentType(APPLICATION_JSON))
                        .andExpect(status().is4xxClientError());
        
    }
   
}

