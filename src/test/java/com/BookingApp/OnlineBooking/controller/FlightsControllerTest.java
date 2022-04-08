package com.BookingApp.OnlineBooking.controller;

import com.BookingApp.OnlineBooking.dto.FlightsDto;
import com.BookingApp.OnlineBooking.repository.FlightsRepository;
import com.BookingApp.OnlineBooking.service.FlightsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class FlightsControllerTest {

    @Mock
    private FlightsService flightsService;

    @InjectMocks
    private FlightsController flightsController;

    @Mock
    private FlightsRepository flightsRepository;

    @Test
    void getAll() {

        FlightsDto flightsDto = FlightsDto.builder()
                .airportName("Cavansir")
                .build();
        List<FlightsDto> flightsDtoList = Mockito.spy(ArrayList.class);
        flightsDtoList.add(flightsDto);
        Mockito.when(flightsService.getAll()).thenReturn(flightsDtoList);

        Assertions.assertDoesNotThrow(() -> flightsController.getAll());
    }

    @Test
    void testFindByCityAndFlightDateEquals() {
        FlightsDto flightsDto = FlightsDto.builder()
                .city("Baku")
                .flightDate(LocalDate.ofEpochDay(2022 - 8 - 25))
                .build();
        List<FlightsDto> flightsDtoList = Mockito.spy(ArrayList.class);
        flightsDtoList.add(flightsDto);
        Mockito.when(flightsService.findByCityAndFlightDateEquals(flightsDto.getCity(), String.valueOf(flightsDto.getFlightDate())))
                .thenReturn(flightsDtoList);

        Assertions.assertDoesNotThrow(() -> flightsController.findByCityAndFlightDateEquals(flightsDto.getCity()
                , String.valueOf(flightsDto.getFlightDate())));
    }

    @Test
    void create() {
            FlightsDto flightsDto = FlightsDto.builder()
                .id(1L)
                .airportName("AHL")
                .city("Quba")
                .flightDate(LocalDate.ofEpochDay(2022 - 8 - 25))
                .flightTime("21:00")
                .freeSeats(30L)
                .build();
        Mockito.when(flightsService.create(new FlightsDto(flightsDto))).thenReturn(flightsDto);

        Assertions.assertDoesNotThrow(() -> flightsController.create(new FlightsDto(flightsDto)));
    }

    @Test
    void update() {
        FlightsDto flightsDto = FlightsDto.builder()
                .id(2L)
                .airportName("AHL")
                .city("Naxcivan")
                .flightDate(LocalDate.ofEpochDay(2022 - 8 - 24))
                .flightTime("21:00")
                .freeSeats(30L)
                .build();


        Assertions.assertDoesNotThrow(() -> flightsController.create(new FlightsDto(flightsDto)));
    }

    @Test
    void delete() {
        FlightsDto flightsDto = FlightsDto.builder()
                .id(2L)
                .build();

        Assertions.assertDoesNotThrow(() -> flightsController.delete(flightsDto.getId()));

    }
}