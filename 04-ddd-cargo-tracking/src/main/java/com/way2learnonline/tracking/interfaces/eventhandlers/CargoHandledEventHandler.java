package com.way2learnonline.tracking.interfaces.eventhandlers;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import com.way2learnonline.shareddomain.events.CargoHandledEvent;
import com.way2learnonline.shareddomain.events.CargoHandledEventData;
import com.way2learnonline.tracking.application.internal.commandservices.AssignTrackingIdCommandService;
import com.way2learnonline.tracking.interfaces.events.transform.TrackingActivityCommandEventAssembler;

@Service
public class CargoHandledEventHandler {

        @Autowired
        private AssignTrackingIdCommandService assignTrackingIdCommandService; // Application Service Dependency


        /**
         * Cargo Handled Event handler
         * @param event
         */
        @StreamListener(target = "cargoHandlingChannel")
        public void observeCargoHandledEvent( CargoHandledEvent event) {
            System.err.println("***Cargo Handled Event in tracking app****Booking ID =="+event.getCargoHandledEventData().getBookingId());
                CargoHandledEventData eventData = event.getCargoHandledEventData();
                System.out.println(eventData.getBookingId());
                System.out.println(eventData.getHandlingLocation());
                System.out.println(eventData.getHandlingCompletionTime());
                System.out.println(eventData.getHandlingType());
                System.out.println(eventData.getVoyageNumber());
            assignTrackingIdCommandService.addTrackingEvent(
                    TrackingActivityCommandEventAssembler.toCommandFromEvent(event));
        }


}
