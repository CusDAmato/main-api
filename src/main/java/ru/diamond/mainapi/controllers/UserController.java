package ru.diamond.mainapi.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.diamond.mainapi.dtos.CreateUserRequestDto;
import ru.diamond.mainapi.dtos.UpdateUserRequestDto;
import ru.diamond.mainapi.dtos.user.UserDto;
import ru.diamond.mainapi.services.UserService;

import static ru.diamond.mainapi.enums.Headers.USER_ID;

@AllArgsConstructor
@RequestMapping(path = "/users")
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserDto createUser(@RequestHeader(USER_ID) String id, @RequestBody CreateUserRequestDto requestDto) {
        return userService.createUser(id, requestDto);
    }

    @PatchMapping
    public UserDto updateUser(@RequestHeader(USER_ID) String id, @RequestBody UpdateUserRequestDto requestDto) {
        return userService.updateUser(id, requestDto);
    }
}
