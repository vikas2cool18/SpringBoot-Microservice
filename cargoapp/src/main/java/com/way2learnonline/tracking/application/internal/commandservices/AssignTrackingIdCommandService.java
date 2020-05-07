package com.way2learnonline.tracking.application.internal.commandservices;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.way2learnonline.tracking.domain.model.aggregates.TrackingActivity;
import com.way2learnonline.tracking.domain.model.aggregates.TrackingNumber;
import com.way2learnonline.tracking.domain.model.commands.AddTrackingEventCommand;
import com.way2learnonline.tracking.domain.model.commands.AssignTrackingNumberCommand;
import com.way2learnonline.tracking.domain.model.entities.TrackingBookingId;
import com.way2learnonline.tracking.infrastructure.repositories.jpa.TrackingRepository;


/**
 * Application Service class for the Tracking Command Service
 */
@Service
public class AssignTrackingIdCommandService {

    @Autowired
    private TrackingRepository trackingRepository;

    /**
     * Service Command method to assign a tracking id to the booked cargo
     * @return Tracking Number of the Cargo
     */
    @Transactional // Inititate the Transaction
    public TrackingNumber assignTrackingNumberToCargo(AssignTrackingNumberCommand assignTrackingNumberCommand){
        String trackingNumber = trackingRepository.nextTrackingNumber();
        assignTrackingNumberCommand.setTrackingNumber(trackingNumber);
        TrackingActivity activity = new TrackingActivity(assignTrackingNumberCommand);
        System.out.println("***Going to store in repository");
        trackingRepository.store(activity); //Store the Cargo

        return new TrackingNumber(trackingNumber);
    }

    /**
     * Service Command method to assign a route to a Cargo
     * @param addTrackingEventCommand
     */
    @Transactional
    public void addTrackingEvent(AddTrackingEventCommand addTrackingEventCommand){
        TrackingActivity trackingActivity = trackingRepository.findByBookingId(
                new TrackingBookingId(addTrackingEventCommand.getBookingId()));

        trackingActivity.addTrackingEvent(addTrackingEventCommand);
        trackingRepository.store(trackingActivity);
    }


}
