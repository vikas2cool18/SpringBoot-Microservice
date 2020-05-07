package com.way2learnonline.tracking.interfaces.eventhandlers;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

import com.way2learnonline.shareddomain.events.CargoRoutedEvent;
import com.way2learnonline.tracking.application.internal.commandservices.AssignTrackingIdCommandService;
import com.way2learnonline.tracking.infrastructure.brokers.CargoEventSource;
import com.way2learnonline.tracking.interfaces.events.transform.TrackingDetailsCommandEventAssembler;

@Service
public class CargoRoutedEventHandler {

    @Autowired
    private AssignTrackingIdCommandService assignTrackingIdCommandService; // Application Service Dependency


    /**
     * Cargo Routed Event Handler Method
     * @param event
     */


    @StreamListener(target = "cargoRouting")
    public void observeCargoRoutedEvent( CargoRoutedEvent event) {
        System.out.println("****Observing Cargo Routed Event***");
        assignTrackingIdCommandService.assignTrackingNumberToCargo(TrackingDetailsCommandEventAssembler.toCommandFromEvent(event));
    }
}
