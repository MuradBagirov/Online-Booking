package com.BookingApp.OnlineBooking.mapper;

import com.BookingApp.OnlineBooking.dto.UserDto;
import com.BookingApp.OnlineBooking.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserDto mapEntityToDto(User user);

    User mapDtoToEntity(UserDto userDto);
}
