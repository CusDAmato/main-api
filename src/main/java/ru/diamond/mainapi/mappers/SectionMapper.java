package ru.diamond.mainapi.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import ru.diamond.mainapi.dtos.category.SectionDto;
import ru.diamond.mainapi.entities.Section;

@Mapper(componentModel = "spring")
public interface SectionMapper {
    SectionDto toSectionDto(Section section);
    List<SectionDto> toListSectionDto(List<Section> sectionList);
}
