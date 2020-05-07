package com.way2learnonline.tracking.domain.model.entities;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Aggregate Identifier for the Cargo Aggregate
 */
@Embeddable
public class TrackingBookingId implements Serializable {

    @Column(name="booking_id")
    private String bookingId;

    public TrackingBookingId(){}

    public TrackingBookingId(String bookingId){this.bookingId = bookingId;}

    public String getBookingId(){return this.bookingId;}
}
