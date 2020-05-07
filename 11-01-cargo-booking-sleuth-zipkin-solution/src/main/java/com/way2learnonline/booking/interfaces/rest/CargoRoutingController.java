package com.way2learnonline.booking.interfaces.rest;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.way2learnonline.booking.application.internal.commandservices.CargoBookingCommandService;
import com.way2learnonline.booking.application.internal.queryservices.CargoBookingQueryService;
import com.way2learnonline.booking.domain.model.aggregates.Cargo;
import com.way2learnonline.booking.domain.model.commands.RouteCargoCommand;
import com.way2learnonline.booking.interfaces.rest.dto.RouteCargoResource;
import com.way2learnonline.booking.interfaces.rest.transform.RouteCargoCommandDTOAssembler;

import io.swagger.annotations.Api;

@RequestMapping("/cargorouting")
@RestController
@Api(value = "Cargo Router Controller",  description = " Endpoints for Routing cargo  ", tags = "Cargo Routing Commands")

public class CargoRoutingController {

    @Autowired
    private CargoBookingCommandService cargoBookingCommandService; // Application Service Dependency
    
	@Autowired
    private CargoBookingQueryService cargoBookingQueryService;
	
	private static final Logger logger = LoggerFactory.getLogger(CargoRoutingController.class);



    /**
     * POST method to route a cargo
     * @param routeCargoResource
     */
    @PostMapping   
    public ResponseEntity<String> routeCargo(@RequestBody RouteCargoResource routeCargoResource){
    	
    	logger.info("*****Inside CargoRoutingController.routeCargo************** ");
    	Cargo cargo=cargoBookingQueryService.find(routeCargoResource.getBookingId());
    	
    	RouteCargoCommand routeCargoCommand=new RouteCargoCommand(routeCargoResource.getBookingId(), cargo.getOrigin().getUnLocCode(),
    			cargo.getRouteSpecification().getDestination().getUnLocCode(), cargo.getRouteSpecification().getArrivalDeadline());
   
        
    	try {
			
    		cargoBookingCommandService.assignRouteToCargo(routeCargoCommand);

            
    	       return  new ResponseEntity<>("Cargo Routed", HttpStatus.OK);
		} catch (Exception e) {
			logger.info("CargoRoutingController.routeCargo()***Cargo not routed as routing service is not available!!");
			 return  new ResponseEntity<>(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
		}
    	
       
    }


}
