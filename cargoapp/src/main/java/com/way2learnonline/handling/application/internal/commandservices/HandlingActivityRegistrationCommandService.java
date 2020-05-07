package com.way2learnonline.handling.application.internal.commandservices;


import org.springframework.stereotype.Service;

import com.way2learnonline.handling.domain.model.aggregates.HandlingActivity;
import com.way2learnonline.handling.domain.model.commands.HandlingActivityRegistrationCommand;
import com.way2learnonline.handling.domain.model.valueobjects.CargoBookingId;
import com.way2learnonline.handling.domain.model.valueobjects.Location;
import com.way2learnonline.handling.domain.model.valueobjects.Type;
import com.way2learnonline.handling.domain.model.valueobjects.VoyageNumber;
import com.way2learnonline.handling.infrastructure.repositories.HandlingActivityRepository;

import javax.transaction.Transactional;

@Service
public class HandlingActivityRegistrationCommandService {


        private HandlingActivityRepository handlingActivityRepository;

        public HandlingActivityRegistrationCommandService(HandlingActivityRepository handlingActivityRepository){
                this.handlingActivityRepository = handlingActivityRepository;
        }

        /**
         * Service Command method to register a new Handling Activity
         * @return BookingId of the CargoBookingId
         */
        @Transactional
        public void registerHandlingActivityService(HandlingActivityRegistrationCommand handlingActivityRegistrationCommand){
        	
                System.out.println("Handling Voyage Number is"+handlingActivityRegistrationCommand.getVoyageNumber());
                
                if(!handlingActivityRegistrationCommand.getVoyageNumber().equals("")) {
                        HandlingActivity handlingActivity = new HandlingActivity(
                                new CargoBookingId(handlingActivityRegistrationCommand.getBookingId()),
                                handlingActivityRegistrationCommand.getCompletionTime(),
                                Type.valueOf(handlingActivityRegistrationCommand.getHandlingType()),
                                new Location(handlingActivityRegistrationCommand.getUnLocode()),
                                new VoyageNumber(handlingActivityRegistrationCommand.getVoyageNumber()));
                        handlingActivityRepository.save(handlingActivity);

                }else{
                        HandlingActivity handlingActivity = new HandlingActivity(
                                new CargoBookingId(handlingActivityRegistrationCommand.getBookingId()),
                                handlingActivityRegistrationCommand.getCompletionTime(),
                                Type.valueOf(handlingActivityRegistrationCommand.getHandlingType()),
                                new Location(handlingActivityRegistrationCommand.getUnLocode()));
                        handlingActivityRepository.save(handlingActivity);
                }




        }
}
