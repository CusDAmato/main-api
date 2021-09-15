package ru.diamond.mainapi.mappers;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import ru.diamond.mainapi.dtos.ClothesDto;
import ru.diamond.mainapi.entities.Clothes;

@Component
public final class ClothesMapper {
    public ClothesDto toDto(Clothes entity) {
        ClothesDto clothesDto = new ClothesDto();
        clothesDto.setUuid(entity.getUuid());
        clothesDto.setImgPath(entity.getImgPath());
        clothesDto.setSection(entity.getCategory().getSection().getCode());
        clothesDto.setCategory(entity.getCategory().getCode());
        clothesDto.setColor(entity.getColor().getCode());
        clothesDto.setPrint(entity.getPrint().getCode());
        return clothesDto;
    }

    public List<ClothesDto> toDtoList(List<Clothes> entityList) {
        return entityList.stream().map(this::toDto).collect(Collectors.toList());
    }
}
