package com.BookingApp.OnlineBooking.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingFlightsDto {

    Long id;

    LocalDate flightDate;

    String FlightTime;

    String destinationPoint;

    String departurePoint;

    Long freeSeats;
}
