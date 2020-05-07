package com.way2learnonline.booking.interfaces.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.way2learnonline.booking.application.internal.commandservices.CargoBookingCommandService;
import com.way2learnonline.booking.application.internal.queryservices.CargoBookingQueryService;
import com.way2learnonline.booking.domain.model.aggregates.BookingId;
import com.way2learnonline.booking.domain.model.aggregates.Cargo;
import com.way2learnonline.booking.interfaces.rest.dto.BookCargoResource;
import com.way2learnonline.booking.interfaces.rest.transform.BookCargoCommandDTOAssembler;

import io.swagger.annotations.Api;

@Controller    // This means that this class is a Controller
@RequestMapping("/cargobooking")
@Api(value = "Cargo Booking Controller",  description = " Endpoints for booking cargo and finding cargo ", tags = "Cargo Booking Commands")
public class CargoBookingController {

	@Autowired
    private CargoBookingCommandService cargoBookingCommandService; // Application Service Dependency
	@Autowired
    private CargoBookingQueryService cargoBookingQueryService;


    /**
     * POST method to book a cargo
     * @param bookCargoResource
     */

    @PostMapping
    @ResponseBody
    public BookingId bookCargo(@RequestBody  BookCargoResource bookCargoResource){
        System.out.println("****Cargo Booked ****"+bookCargoResource.getBookingAmount());
        
        BookingId bookingId  = cargoBookingCommandService.bookCargo(
                BookCargoCommandDTOAssembler.toCommandFromDTO(bookCargoResource));

        return bookingId;
    }

    /**
     * GET method to retrieve a Cargo
     * @param bookingId
     * @return
     */
    @GetMapping("/findCargo")
    @ResponseBody
    public Cargo findByBookingId(@RequestParam("bookingId") String bookingId){
    	System.out.println("CargoBookingController.findByBookingId()" + bookingId);
        Cargo cargo= cargoBookingQueryService.find(bookingId);
        System.out.println("FindById : "+cargo);
        return cargo;
    }
}
