package ru.diamond.mainapi.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.diamond.mainapi.dtos.CreateUserRequestDto;
import ru.diamond.mainapi.dtos.UserDto;
import ru.diamond.mainapi.services.UserService;

@AllArgsConstructor
@RequestMapping(path = "/users")
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/{id}")
    public UserDto createUser(@PathVariable("id") String id, @RequestBody CreateUserRequestDto requestDto) {
        return userService.createUser(id, requestDto);
    }
}
