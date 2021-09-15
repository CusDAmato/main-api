package ru.diamond.mainapi.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.diamond.mainapi.dtos.CreateUserRequestDto;
import ru.diamond.mainapi.dtos.UserDto;
import ru.diamond.mainapi.entities.User;
import ru.diamond.mainapi.mappers.UserMapper;
import ru.diamond.mainapi.repositories.UserRepository;

@AllArgsConstructor
@Service
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserDto createUser(String id, CreateUserRequestDto requestDto) {
        User user = User.builder()
                .id(id)
                .name(requestDto.getName())
                .email(requestDto.getEmail()).build();
        userRepository.save(user);
        return userMapper.toUserDto(user);
    }
}
