package com.BookingApp.OnlineBooking.repository;

import com.BookingApp.OnlineBooking.model.Flights;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface FlightsRepository extends JpaRepository<Flights, Long> {

    List<Flights> findByCityAndFlightDate(String city, LocalDate flightDate);
}

