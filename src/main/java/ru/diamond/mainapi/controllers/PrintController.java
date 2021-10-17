package ru.diamond.mainapi.controllers;

import java.util.Set;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.diamond.mainapi.dtos.PrintDto;
import ru.diamond.mainapi.services.PrintService;

@AllArgsConstructor
@RequestMapping(path = "/prints")
@RestController
public class PrintController {

    private final PrintService printService;

    @GetMapping
    public Set<PrintDto> getAllPrints() {
        return printService.getAllPrints();
    }
}
