package com.assignment.reverse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.assignment.reverse.service.ReverseService;

import org.apache.logging.log4j.Logger;

import javax.validation.constraints.Pattern;

import org.apache.logging.log4j.LogManager;

@RestController
@RequestMapping(value = "/api")
@Validated
public class ReverseController {

   private static final Logger logger = LogManager.getLogger(ReverseController.class);
    
    @Autowired
    private ReverseService reverseService;

    @GetMapping(value = "/reverse/{inputString}")
    public String reverse(@PathVariable (value = "inputString")           
    		@Pattern(regexp = "^[a-zA-Z ]*$") String inputString) {
        logger.info("Requesting to convert String: {}", inputString);
        return reverseService.reverseLogic(inputString);

    }


}

