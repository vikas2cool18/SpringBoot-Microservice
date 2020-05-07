package com.way2learnonline.shareddomain.events;

/**
 * Event Data for the Cargo Booked Event
 */
public class CargoRoutedEventData {

    private String bookingId;
    
    public CargoRoutedEventData() {
		// TODO Auto-generated constructor stub
	}

    public CargoRoutedEventData(String bookingId){
        this.bookingId = bookingId;

    }

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
   
}
