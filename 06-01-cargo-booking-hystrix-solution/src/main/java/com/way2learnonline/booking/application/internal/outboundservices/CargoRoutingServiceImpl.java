package com.way2learnonline.booking.application.internal.outboundservices;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.way2learnonline.shareddomain.model.TransitPath;

@Service
public class CargoRoutingServiceImpl implements CargoRoutingService {
	
	

	@Autowired
	private RestTemplate restTemplate;
	
	
	


			
			@HystrixCommand(fallbackMethod = "findOptimalRouteFallback",
		            commandProperties = {@HystrixProperty(name="execution.timeout.enabled", value="false")})
			
			
		
	public TransitPath findOptimalRoute(String originUnLocode, String destinationUnLocode, String deadline) {
		 final String REST_URI
         = "http://routing-service/cargorouting/optimalRoute?origin={origin}&destination={destination}&deadline={deadline}";
 

 
    	 System.err.println("CargoRoutingServiceImpl.findOptimalRoute()======hitting cargorouting service=========");
 
    	 TransitPath transitPath =restTemplate.getForObject( REST_URI, TransitPath.class,  originUnLocode,   destinationUnLocode,deadline);
		return transitPath;
	}
	
	public TransitPath findOptimalRouteFallback(String originUnLocode, String destinationUnLocode, String deadline) {
		
		System.err.println("CargoRoutingServiceImpl.findOptimalRouteFallback()******");
		return new TransitPath();
		
	}

}
