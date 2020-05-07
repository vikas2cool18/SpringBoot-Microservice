package com.way2learnonline.tracking.infrastructure.brokers;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * Interface depicting all output channels
 */
public interface CargoEventSource {

    @Input("cargoBooking")
    SubscribableChannel cargoBooking();

    @Input("cargoRouting")
    SubscribableChannel cargoRouting();
    
    @Input("cargoHandlingChannel")
    SubscribableChannel cargoHandling();

}
