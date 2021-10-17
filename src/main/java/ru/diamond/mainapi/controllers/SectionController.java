package ru.diamond.mainapi.controllers;

import java.util.Set;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.diamond.mainapi.dtos.category.SectionDto;
import ru.diamond.mainapi.services.SectionService;

@AllArgsConstructor
@RequestMapping(path = "/sections")
@RestController
public class SectionController {
    private final SectionService sectionService;

    @GetMapping
    public Set<SectionDto> getAllSections() {
        return sectionService.getAllSections();
    }
}
