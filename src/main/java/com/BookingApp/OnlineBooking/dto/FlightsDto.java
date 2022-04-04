package com.BookingApp.OnlineBooking.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FlightsDto {

    Long id;

    String city;

    LocalDate flightDate;

    String FlightTime;

    String destinationPoint;

    String departurePoint;

    String airportName;

    Long freeSeats;
}
