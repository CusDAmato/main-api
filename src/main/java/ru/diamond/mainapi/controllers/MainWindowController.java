package ru.diamond.mainapi.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.diamond.mainapi.dtos.main.MainWindowDto;
import ru.diamond.mainapi.enums.Headers;
import ru.diamond.mainapi.services.UserService;

import static ru.diamond.mainapi.enums.Headers.USER_ID;

@AllArgsConstructor
@RequestMapping(path = "/main-window")
@RestController
public class MainWindowController {

    private final UserService userService;

    @GetMapping
    public MainWindowDto getUser(@RequestHeader(USER_ID) String id) {
        return userService.getUserForMainWindow(id);
    }

}
