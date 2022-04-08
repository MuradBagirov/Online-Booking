package com.BookingApp.OnlineBooking.service.serviceImpl;

import com.BookingApp.OnlineBooking.dto.UserDto;
import com.BookingApp.OnlineBooking.model.User;
import com.BookingApp.OnlineBooking.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void getAll() {
        User user = User.builder()
                .firstName("Cavansir")
                .build();
        List<User> userList = Mockito.spy(ArrayList.class);
        userList.add(user);
        Mockito.when(userRepository.findAll()).thenReturn(userList);

        Assertions.assertDoesNotThrow(() -> userService.getAll());
    }

    @Test
    void create() {
        User user = User.builder()
                .id(5L)
                .firstName("Cavansir")
                .build();
        Mockito.when(userRepository.save(user)).thenReturn(user);

        Assertions.assertDoesNotThrow(() -> userService.create(1L, modelMapper.map(user, UserDto.class)));
    }

    @Test
    void update() {
        UserDto userDto = UserDto.builder()
                .id(2L)
                .firstName("MMm")
                .build();

        Assertions.assertDoesNotThrow(() -> userService.create(1L, new UserDto(userDto)));
    }

    @Test
    void delete() {

        UserDto userDto = UserDto.builder()
                .id(2L)
                .build();

        Assertions.assertDoesNotThrow(() -> userService.delete(userDto.getId()));
    }
}