package com.way2learnonline.booking.infrastructure.infrastructure.brokers;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * Interface depicting all output channels
 */
public interface CargoEventSource {

    @Output("cargoBookingChannel")
    MessageChannel cargoBooking();

    @Output("cargoRoutingChannel")
    MessageChannel cargoRouting();
    
    @Input("cargoHandlingChannel")
    SubscribableChannel cargoHandling();

}
