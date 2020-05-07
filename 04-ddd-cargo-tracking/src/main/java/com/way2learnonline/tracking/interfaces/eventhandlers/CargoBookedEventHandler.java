package com.way2learnonline.tracking.interfaces.eventhandlers;



import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import com.way2learnonline.shareddomain.events.CargoBookedEvent;

@Service
public class CargoBookedEventHandler {

	@StreamListener(target = "cargoBookingChannel")
    public void handleCargoBookedEvent( CargoBookedEvent event) {
        // Processing of an event
        System.err.println("***Cargo Booked Event Handled in Tracking App***"+event.getCargoBookedEventData().getBookingId());
    }
}
