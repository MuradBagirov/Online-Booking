package com.BookingApp.OnlineBooking.service.serviceImpl;

import com.BookingApp.OnlineBooking.dto.FlightsDto;
import com.BookingApp.OnlineBooking.model.Flights;
import com.BookingApp.OnlineBooking.repository.FlightsRepository;
import com.BookingApp.OnlineBooking.service.FlightsService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FlightsImpl implements FlightsService {

    private final ModelMapper modelMapper;

    private final FlightsRepository flightsRepository;


    @Override
    public List<FlightsDto> getAll() {
        List<Flights> all = flightsRepository.findAll();
        List<FlightsDto> collect = all.stream().map(flightsInfo -> modelMapper.map(flightsInfo, FlightsDto.class))
                .collect(Collectors.toList());
        return collect;
    }

    @Override
    public FlightsDto create(FlightsDto airportDto) {
        Flights flights = modelMapper.map(airportDto, Flights.class);
        Flights save = flightsRepository.save(flights);
        return modelMapper.map(save, FlightsDto.class);
    }

    @Override
    public FlightsDto update(FlightsDto airportDto) {
        Flights flights = flightsRepository.findById(airportDto.getId()).orElseThrow(() -> new RuntimeException("User not found"));
        flights.setAirportName(airportDto.getAirportName());
        flights.setCity(airportDto.getCity());

        Flights save = flightsRepository.save(flights);

        return modelMapper.map(save, FlightsDto.class);

    }

    @Override
    public void delete(Long id) {
        flightsRepository.deleteById(id);
    }

    @Override
    public List<FlightsDto> findByCityAndFlightDateEquals(String city, String flightDate) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate1 = LocalDate.parse(flightDate, dateTimeFormatter);

        List<Flights> flightsList = flightsRepository.findByCityAndFlightDate(city, localDate1);
        return flightsList.stream()
                .map(flightsInfo -> modelMapper.map(flightsInfo, FlightsDto.class))
                .collect(Collectors.toList());
    }

}
