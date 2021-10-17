package ru.diamond.mainapi.dtos.main;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Set;
import lombok.Getter;
import ru.diamond.mainapi.dtos.story.StoryDto;
import ru.diamond.mainapi.dtos.user.UserDto;

@Getter
public class MainWindowDto {
    private final UserDto user;
    private final JsonNode looks;
    private final Set<StoryDto> stories;

    @JsonCreator
    public MainWindowDto(@JsonProperty("user") UserDto user,
                         @JsonProperty("looks") JsonNode looks,
                         @JsonProperty("stories") Set<StoryDto> stories) {
        this.user = user;
        this.looks = looks;
        this.stories = stories;
    }
}
