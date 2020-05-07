package com.way2learnonline.tracking.interfaces.eventhandlers;



import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import com.way2learnonline.shareddomain.events.CargoBookedEvent;

@Service
public class CargoBookedEventHandler {

	@StreamListener(target = "cargoBooking")
    public void testEventObserving( CargoBookedEvent event) {
        // Processing of an event
        System.out.println("***Just a Test***"+event.getCargoBookedEventData().getBookingId());
    }
}
