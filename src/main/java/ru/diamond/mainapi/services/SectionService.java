package ru.diamond.mainapi.services;

import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.diamond.mainapi.dtos.category.SectionDto;
import ru.diamond.mainapi.mappers.SectionMapper;
import ru.diamond.mainapi.repositories.SectionRepository;

@Service
@AllArgsConstructor
public class SectionService {
    private final SectionRepository sectionRepository;
    private final SectionMapper sectionMapper;

    public Set<SectionDto> getAllSections() {
        return new HashSet<>(sectionMapper.toListSectionDto(sectionRepository.findAll()));
    }
}
