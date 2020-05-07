package com.way2learnonline.booking.application.internal.outboundservices;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.way2learnonline.shareddomain.model.TransitPath;

@Service
public class CargoRoutingServiceFallback implements CargoRoutingService {

			
		
	public TransitPath findOptimalRoute(String originUnLocode, String destinationUnLocode, String deadline) {
				System.err.println("CargoRoutingServiceImpl.findOptimalRouteFallback()******");
				return new TransitPath();
	}
	
	

}
