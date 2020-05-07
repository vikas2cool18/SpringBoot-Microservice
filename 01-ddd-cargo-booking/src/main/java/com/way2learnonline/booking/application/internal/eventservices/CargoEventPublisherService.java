package com.way2learnonline.booking.application.internal.eventservices;


import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

import com.way2learnonline.booking.infrastructure.infrastructure.brokers.CargoEventSource;
import com.way2learnonline.shareddomain.model.events.CargoBookedEvent;
import com.way2learnonline.shareddomain.model.events.CargoRoutedEvent;


@Service

public class CargoEventPublisherService {

    CargoEventSource cargoEventSource;

    public CargoEventPublisherService(CargoEventSource cargoEventSource){
        this.cargoEventSource = cargoEventSource;
    }

    @TransactionalEventListener
    public void handleCargoBookedEvent(CargoBookedEvent cargoBookedEvent){
    	System.err.println("Publishing CargoBookedEvent with booking id *** " +cargoBookedEvent.getCargoBookedEventData().getBookingId());
        cargoEventSource.cargoBooking().send(MessageBuilder.withPayload(cargoBookedEvent).build());
    }

    @TransactionalEventListener
    public void handleCargoRoutedEvent(CargoRoutedEvent cargoRoutedEvent){
    	System.err.println("Publishing CargoRoutedEvent with booking id ***"+cargoRoutedEvent.getCargoRoutedEventData().getBookingId());
        cargoEventSource.cargoRouting().send(MessageBuilder.withPayload(cargoRoutedEvent).build());
    }
}
