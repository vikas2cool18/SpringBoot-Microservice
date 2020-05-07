package com.way2learnonline.handling.infrastructure.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.way2learnonline.handling.domain.model.aggregates.HandlingActivity;
import com.way2learnonline.handling.domain.model.valueobjects.CargoBookingId;

public interface HandlingActivityRepository extends JpaRepository<HandlingActivity,Long> {
    HandlingActivity findByBookingId(CargoBookingId cargoBookingId);
}
