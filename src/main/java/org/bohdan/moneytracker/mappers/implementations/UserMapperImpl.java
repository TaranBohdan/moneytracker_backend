package org.bohdan.moneytracker.mappers.implementations;

import org.bohdan.moneytracker.mappers.UserMapper;
import org.bohdan.moneytracker.models.dtos.UserDto;
import org.bohdan.moneytracker.models.entities.User;

public class UserMapperImpl implements UserMapper
{
    @Override
    public UserDto userToUserDto(User user)
    {
        if (user == null)
        {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());

        return userDto;
    }

    @Override
    public User userDtoToUser(UserDto userDto)
    {
        User user = new User();

        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());

        return user;
    }
}
