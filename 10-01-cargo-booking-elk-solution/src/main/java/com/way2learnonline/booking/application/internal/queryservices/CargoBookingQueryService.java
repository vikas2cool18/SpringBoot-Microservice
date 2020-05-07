package com.way2learnonline.booking.application.internal.queryservices;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.way2learnonline.booking.domain.model.aggregates.BookingId;
import com.way2learnonline.booking.domain.model.aggregates.Cargo;
import com.way2learnonline.booking.infrastructure.repositories.CargoRepository;

import java.util.List;

/**
 * Application Service which caters to all queries related to the Booking Bounded Context
 */
@Service
public class CargoBookingQueryService {

	@Autowired
    private CargoRepository cargoRepository; // Inject Dependencies

    /**
     * Find all Cargos
     * @return List<Cargo>
     */

    public List<Cargo> findAll(){
        return cargoRepository.findAll();
    }

    /**
     * List All Booking Identifiers
     * @return List<BookingId>
     */
   public List<BookingId> findAllBookingIds(){

       return cargoRepository.findAllBookingIds();
   }

    /**
     * Find a specific Cargo based on its Booking Id
     * @param bookingId
     * @return Cargo
     */
    public Cargo find(String bookingId){
        return cargoRepository.findByBookingId(bookingId);
    }
}
