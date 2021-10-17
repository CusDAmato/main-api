package ru.diamond.mainapi.mappers;

import org.mapstruct.Mapper;
import ru.diamond.mainapi.dtos.user.UserDto;
import ru.diamond.mainapi.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toUserDto(User user);
}
