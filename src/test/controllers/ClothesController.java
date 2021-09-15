package ru.diamond.mainapi.controllers;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.diamond.mainapi.dtos.ClothesDto;
import ru.diamond.mainapi.enums.PartsOfTheDay;
import ru.diamond.mainapi.services.ClothesService;

@AllArgsConstructor
@RequestMapping("/clothes")
@RestController
public class ClothesController {

    private final ClothesService clothesService;

    @GetMapping("/fitted/{userUuid}")
    public Map<PartsOfTheDay, List<List<ClothesDto>>> getFittedOutfit(@PathVariable UUID userUuid) {
        return clothesService.getFittedOutfit(userUuid);
    }

//    @PostMapping()
}
