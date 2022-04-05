package com.BookingApp.OnlineBooking.service.serviceImpl;

import com.BookingApp.OnlineBooking.dto.UserDto;
import com.BookingApp.OnlineBooking.mapper.UserMapper;
import com.BookingApp.OnlineBooking.model.BookingFlights;
import com.BookingApp.OnlineBooking.model.Flights;
import com.BookingApp.OnlineBooking.model.User;
import com.BookingApp.OnlineBooking.repository.BookingFlightsRepository;
import com.BookingApp.OnlineBooking.repository.FlightsRepository;
import com.BookingApp.OnlineBooking.repository.UserRepository;
import com.BookingApp.OnlineBooking.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final FlightsRepository flightsRepository;
    private final ModelMapper modelMapper;
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public List<UserDto> getAll() {
        List<User> all = userRepository.findAll();
        List<UserDto> collect = all.stream().map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
        return collect;
    }

    @Override
    public UserDto create(Long flightId, UserDto userDto) {

        Flights flights = flightsRepository.findById(flightId)
                .orElseThrow(() -> new RuntimeException("This flight info is not available"));

        Long collect = userDto.getBookingFlightsList().stream().mapToLong(BookingFlights::getFreeSeats).sum();

        Long stock = flights.getFreeSeats() - 1;

        if (flights.getFreeSeats() > collect) {
            flights.setFreeSeats(stock);
            User user1 = new User();
            user1.setFirstName(userDto.getFirstName());
            user1.setLastName(userDto.getLastName());
            user1.setBookingFlightsList(userDto.getBookingFlightsList());

        } else throw new RuntimeException("Empty seats not found");

        User map = userMapper.mapDtoToEntity(userDto);
        User save = userRepository.save(map);
        return userMapper.mapEntityToDto(save);
    }

    @Override
    public UserDto update(UserDto userDto) {
        User user = userRepository.findById(userDto.getId()).orElseThrow(() -> new RuntimeException("User not found"));
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setBookingFlightsList(userDto.getBookingFlightsList());

        User save = userRepository.save(user);

        return modelMapper.map(save, UserDto.class);

    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
