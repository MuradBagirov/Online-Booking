package com.BookingApp.OnlineBooking.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String firstName;
    String lastName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_booking_id")
    List<BookingFlights> bookingFlightsList;
}
