package ru.diamond.mainapi.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import ru.diamond.mainapi.dtos.ColorDto;
import ru.diamond.mainapi.entities.Color;

@Mapper(componentModel = "spring")
public interface ColorMapper {
    ColorDto toColorDto(Color color);
    List<ColorDto> toListColorDto(List<Color> colorSet);
}
