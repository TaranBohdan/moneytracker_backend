package org.bohdan.moneytracker.mappers;

import org.bohdan.moneytracker.models.dtos.UserDto;
import org.bohdan.moneytracker.models.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper
{
    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDto);
}
