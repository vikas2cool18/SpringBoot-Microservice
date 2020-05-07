package com.way2learnonline.booking.application.internal.outboundservices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.way2learnonline.shareddomain.model.TransitPath;


@FeignClient(name = "routing-service",fallback = CargoRoutingServiceFallback.class)
public interface CargoRoutingService {
	
	
	@GetMapping(path = "/cargorouting/optimalRoute")
	    
	public TransitPath findOptimalRoute(
	             @RequestParam("origin") String originUnLocode,
	             @RequestParam("destination") String destinationUnLocode,
	             @RequestParam("deadline") String deadline);
	
	// public TransitPath findOptimalRoute(String originUnLocode, String destinationUnLocode, String deadline) ;

}
