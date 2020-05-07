package com.way2learnonline.handling.application.internal.outboundservices;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

import com.way2learnonline.handling.infrastructure.brokers.rabbitmq.CargoEventSource;
import com.way2learnonline.shareddomain.events.CargoHandledEvent;

/**
 *
 */
@Service
@EnableBinding(CargoEventSource.class)
public class CargoEventPublisherService {

    CargoEventSource cargoEventSource;

    public CargoEventPublisherService(CargoEventSource cargoEventSource){
        this.cargoEventSource = cargoEventSource;
    }

    @TransactionalEventListener
    public void handleCargoHandledEvent(CargoHandledEvent cargoHandledEvent){
    	System.err.println("Publishing CargoHandledEvent**** BookingId " +cargoHandledEvent.getCargoHandledEventData().getBookingId() +
    						"HandlingType: "+cargoHandledEvent.getCargoHandledEventData().getHandlingType() );
        cargoEventSource.cargoHandling().send(MessageBuilder.withPayload(cargoHandledEvent).build());
    }
}
