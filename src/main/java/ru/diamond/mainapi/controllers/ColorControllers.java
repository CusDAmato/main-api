package ru.diamond.mainapi.controllers;

import java.util.Set;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.diamond.mainapi.dtos.ColorDto;
import ru.diamond.mainapi.services.ColorService;

@AllArgsConstructor
@RequestMapping(path = "/colors")
@RestController
public class ColorControllers {

    private final ColorService colorService;

    @GetMapping
    public Set<ColorDto> getAllColors() {
        return colorService.getAllColors();
    }
}
