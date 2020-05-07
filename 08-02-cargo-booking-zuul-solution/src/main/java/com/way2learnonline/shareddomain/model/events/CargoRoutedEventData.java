package com.way2learnonline.shareddomain.model.events;

/**
 * Event Data for the Cargo Booked Event
 */
public class CargoRoutedEventData {

    private String bookingId;

    public CargoRoutedEventData(String bookingId){
        this.bookingId = bookingId;

    }
    public String getBookingId(){return this.bookingId;}

}
