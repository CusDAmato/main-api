package ru.diamond.mainapi.services;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.diamond.mainapi.dtos.ColorDto;
import ru.diamond.mainapi.mappers.ColorMapper;
import ru.diamond.mainapi.repositories.ColorRepository;

@Service
@AllArgsConstructor
public class ColorService {

    private final ColorRepository colorRepository;
    private final ColorMapper colorMapper;

    public Set<ColorDto> getAllColors() {
        return new HashSet<>(colorMapper.toListColorDto(colorRepository.findAll()));
    }
}
