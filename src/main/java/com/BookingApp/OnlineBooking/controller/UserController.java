package com.BookingApp.OnlineBooking.controller;

import com.BookingApp.OnlineBooking.dto.UserDto;
import com.BookingApp.OnlineBooking.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        List<UserDto> all = userService.getAll();
        return ResponseEntity.ok(all);
    }

    @PostMapping
    public UserDto create(@RequestParam Long flightId,@RequestBody UserDto airportDto) {
        return userService.create(flightId,airportDto);
    }

    @PutMapping
    public UserDto update(@RequestBody UserDto airportDto){
        return userService.update(airportDto);
    }

    @DeleteMapping
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

    }


