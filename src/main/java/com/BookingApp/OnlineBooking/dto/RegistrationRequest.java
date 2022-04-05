package com.BookingApp.OnlineBooking.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegistrationRequest {

    final String name;
    final String lastname;
    final String email;
    final String password;


}
