package com.BookingApp.OnlineBooking.service;

import com.BookingApp.OnlineBooking.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAll();

    UserDto create(Long flightId, UserDto airportDto);

    UserDto update(UserDto airportDto);

    void delete(Long id);

}
