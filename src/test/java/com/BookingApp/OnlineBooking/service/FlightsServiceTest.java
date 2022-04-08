package com.BookingApp.OnlineBooking.service;

import com.BookingApp.OnlineBooking.dto.FlightsDto;
import com.BookingApp.OnlineBooking.model.Flights;
import com.BookingApp.OnlineBooking.repository.FlightsRepository;
import com.BookingApp.OnlineBooking.service.serviceImpl.FlightsImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FlightsServiceTest {

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private FlightsRepository flightsRepository;

    @InjectMocks
    private FlightsImpl flightService;

    @Test
    void getAll() {
        Flights flightsDto = Flights.builder()
                .airportName("AHL")
                .city("Quba")
                .flightDate(LocalDate.ofEpochDay(2022 - 8 - 25))
                .flightTime("21:00")
                .freeSeats(30L)
                .build();
        List<Flights> flightsDtoList = Mockito.spy(ArrayList.class);
        flightsDtoList.add(flightsDto);
        Mockito.when(flightsRepository.findAll()).thenReturn(flightsDtoList);

        Assertions.assertDoesNotThrow(() -> flightService.getAll());
    }

    @Test
    void create() {
        Flights flights = Flights.builder()
                .id(2L)
                .airportName("AHL")
                .city("Quba")
                .flightDate(LocalDate.ofEpochDay(2022 - 8 - 25))
                .flightTime("21:00")
                .freeSeats(30L)
                .build();
        Mockito.when(flightsRepository.save(flights)).thenReturn(flights);

        Assertions.assertDoesNotThrow(() -> flightService.create(modelMapper.map(flights, FlightsDto.class)));
    }


    @Test
     void update(){
         FlightsDto flightsDto = FlightsDto.builder()
                 .id(2L)
                 .airportName("AHL")
                 .city("Naxcivan")
                 .flightDate(LocalDate.ofEpochDay(2022 - 8 - 24))
                 .flightTime("21:00")
                 .freeSeats(30L)
                 .build();

         Assertions.assertDoesNotThrow(() -> flightService.create(new FlightsDto(flightsDto)));
     }

     @Test
    void delete(){
         FlightsDto flightsDto = FlightsDto.builder()
                 .id(2L)
                 .build();

         Assertions.assertDoesNotThrow(() -> flightService.delete(flightsDto.getId()));
     }

     @Test
     void findByCityAndFlightDateEquals(){

         FlightsDto flightsDto = FlightsDto.builder()
                 .id(3L)
                 .city("Baku")
                 .flightDate(LocalDate.of(2022,2,25))
                 .build();
         List<FlightsDto> flightsDtoList = Mockito.spy(ArrayList.class);
         flightsDtoList.add(flightsDto);
         Mockito.when(flightsRepository.findByCityAndFlightDate(flightsDto.getCity(), flightsDto.getFlightDate()));

         Assertions.assertDoesNotThrow(() -> flightService.findByCityAndFlightDateEquals(flightsDto.getCity()
                 , String.valueOf(flightsDto.getFlightDate())));
     }
}
