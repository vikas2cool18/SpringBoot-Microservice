package com.way2learnonline.booking.application.internal.outboundservices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.way2learnonline.shareddomain.model.TransitPath;

//TODO-1 modify the below annotation such that the proxy will look up for gateway in eureka

@FeignClient(name = "gateway",fallback = CargoRoutingServiceFallback.class)
public interface CargoRoutingService {
	
	
	//TODO-2 modify the below annpotation such that the request goes through gateway 
	@GetMapping(path = "/routing-service/cargorouting/optimalRoute")	    
	public TransitPath findOptimalRoute(
	             @RequestParam("origin") String originUnLocode,
	             @RequestParam("destination") String destinationUnLocode,
	             @RequestParam("deadline") String deadline);
	
	// public TransitPath findOptimalRoute(String originUnLocode, String destinationUnLocode, String deadline) ;

}
