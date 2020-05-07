package com.way2learnonline.booking.infrastructure.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.way2learnonline.booking.domain.model.aggregates.BookingId;
import com.way2learnonline.booking.domain.model.aggregates.Cargo;

/**
 * Repository class for the Cargo Aggregate
 */
public interface CargoRepository extends JpaRepository<Cargo, Long> {

     Cargo findByBookingId(String bookingId);

     List<BookingId> findAllBookingIds();

     List<Cargo> findAll();

}
