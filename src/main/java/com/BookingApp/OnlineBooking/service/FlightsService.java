package com.BookingApp.OnlineBooking.service;

import com.BookingApp.OnlineBooking.dto.FlightsDto;

import java.util.List;

public interface FlightsService {
    List<FlightsDto> getAll();

    FlightsDto create(FlightsDto flightsDto);

    FlightsDto update(FlightsDto flightsDto);

    void delete(Long id);

    List<FlightsDto> findByCityAndFlightDateEquals(String city, String flightDate);


}
