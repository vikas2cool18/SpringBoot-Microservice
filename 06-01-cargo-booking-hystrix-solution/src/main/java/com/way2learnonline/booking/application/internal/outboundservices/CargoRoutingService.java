package com.way2learnonline.booking.application.internal.outboundservices;

import org.springframework.web.bind.annotation.RequestParam;

import com.way2learnonline.shareddomain.model.TransitPath;

public interface CargoRoutingService {
	
	 public TransitPath findOptimalRoute(String originUnLocode, String destinationUnLocode, String deadline) ;

}
