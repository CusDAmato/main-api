package ru.diamond.mainapi.services;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import ru.diamond.mainapi.dtos.category.CategoryDto;
import ru.diamond.mainapi.dtos.category.SectionCategoryDto;
import ru.diamond.mainapi.dtos.category.SectionDto;
import ru.diamond.mainapi.mappers.CategoryMapper;
import ru.diamond.mainapi.mappers.SectionMapper;
import ru.diamond.mainapi.repositories.SectionRepository;

@Service
@AllArgsConstructor
public class CategoryService {

    private final SectionRepository sectionRepository;
    private final SectionMapper sectionMapper;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public Set<SectionCategoryDto> getCategoriesBySection() {
        return sectionRepository.findAllWithCategories().stream()
                .map(section -> {
                    SectionDto sectionDto = sectionMapper.toSectionDto(section);
                    Set<CategoryDto> categorySet = categoryMapper.toCategoryDtoSet(section.getCategories());
                    return new SectionCategoryDto(sectionDto, categorySet);
                })
                .collect(Collectors.toSet());
    }
}
