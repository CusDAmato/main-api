package ru.diamond.mainapi.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.diamond.mainapi.dtos.story.StoryDto;
import ru.diamond.mainapi.entities.Story;

@Mapper(componentModel = "spring")
public interface StoryMapper {
    StoryDto toStoryDto(Story story);
}
