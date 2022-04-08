package com.BookingApp.OnlineBooking.controller;

import com.BookingApp.OnlineBooking.dto.FlightsDto;
import com.BookingApp.OnlineBooking.dto.UserDto;
import com.BookingApp.OnlineBooking.service.FlightsService;
import com.BookingApp.OnlineBooking.service.UserService;
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

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {


    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    void getAll() {

        UserDto userDto = UserDto.builder()
                .firstName("Cavansir")
                .build();
            List<UserDto> userDtoList = Mockito.spy(ArrayList.class);
        userDtoList.add(userDto);
        Mockito.when(userService.getAll()).thenReturn(userDtoList);

        Assertions.assertDoesNotThrow(() -> userController.getAll());
    }

    @Test
    void create() {

        UserDto userDto = UserDto.builder()
                .id(1L)
                .firstName("murad")
                .build();
        Mockito.when(userService.create(1L,new UserDto(userDto))).thenReturn(userDto);

        Assertions.assertDoesNotThrow(() -> userController.create(1L,new UserDto(userDto)));
    }

    @Test
    void update() {

        UserDto userDto = UserDto.builder()
                .id(2L)
                .firstName("Cavansir")
                .build();


        Assertions.assertDoesNotThrow(() -> userController.create(1L,new UserDto(userDto)));
    }

    @Test
    void delete() {
        UserDto userDto = UserDto.builder()
                .id(2L)
                .build();

        Assertions.assertDoesNotThrow(() -> userController.delete(userDto.getId()));

    }
}