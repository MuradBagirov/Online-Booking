package com.BookingApp.OnlineBooking.controller;


import com.BookingApp.OnlineBooking.dto.FlightsDto;
import com.BookingApp.OnlineBooking.service.FlightsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airports")
@RequiredArgsConstructor
public class FlightsController {

    private final FlightsService flightsService;

    @GetMapping("/list")
    public ResponseEntity<List<FlightsDto>> getAll() {
        List<FlightsDto> all = flightsService.getAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/filter")
    public List <FlightsDto> findByCityAndFlightDateEquals(@RequestParam String city,
                                                           @RequestParam String flightDate) {

        return flightsService.findByCityAndFlightDateEquals(city,flightDate);
    }


    @PostMapping
    public FlightsDto create( @RequestBody FlightsDto flightsDto) {
        return flightsService.create(flightsDto);
    }

    @PutMapping
    public FlightsDto update(@RequestBody FlightsDto flightsDto) {
        return flightsService.update(flightsDto);
    }

    @DeleteMapping
    public void delete(@PathVariable Long id) {
        flightsService.delete(id);
    }

}
