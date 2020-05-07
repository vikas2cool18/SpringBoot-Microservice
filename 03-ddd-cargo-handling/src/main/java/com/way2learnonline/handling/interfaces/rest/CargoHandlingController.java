package com.way2learnonline.handling.interfaces.rest;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.way2learnonline.handling.application.internal.commandservices.HandlingActivityRegistrationCommandService;
import com.way2learnonline.handling.interfaces.rest.dto.HandlingActivityRegistrationResource;
import com.way2learnonline.handling.interfaces.rest.transform.HandlingActivityRegistrationCommandDTOAssembler;

import io.swagger.annotations.Api;

/**
 * Controller for the REST API
 */
@Controller    // This means that this class is a Controller
@RequestMapping("/cargohandling")
@Api(value = "Cargo Handling Controller",  description = " Endpoints for Handling ", tags = "Cargo Handling Commands")

public  class CargoHandlingController {


    private HandlingActivityRegistrationCommandService handlingActivityRegistrationCommandService; // Application Service Dependency

    /**
     * Provide the dependencies
     * @param handlingActivityRegistrationCommandService
     */
    public CargoHandlingController(HandlingActivityRegistrationCommandService handlingActivityRegistrationCommandService){
        this.handlingActivityRegistrationCommandService = handlingActivityRegistrationCommandService;
    }

    /**
     * POST method to register Handling Activities
     * @param handlingActivityRegistrationResource
     */
    @PostMapping
    @ResponseBody
    public String registerHandlingActivity(@RequestBody HandlingActivityRegistrationResource handlingActivityRegistrationResource){
        System.out.println("***"+handlingActivityRegistrationResource.getBookingId());
        System.out.println("***"+handlingActivityRegistrationResource.getHandlingType());

        handlingActivityRegistrationCommandService.registerHandlingActivityService(HandlingActivityRegistrationCommandDTOAssembler.toCommandFromDTO(handlingActivityRegistrationResource));
        return "Handling Activity Registered";
    }
}
