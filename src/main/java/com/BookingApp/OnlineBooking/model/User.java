package com.BookingApp.OnlineBooking.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
