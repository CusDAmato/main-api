package ru.diamond.mainapi.controllers;

import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.diamond.mainapi.dtos.user.UserIdDto;
import ru.diamond.mainapi.services.StoryService;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/stories")
public class StoryController {

    private final StoryService storyService;

    @PatchMapping("/{uuid}")
    public void storyWasSeenByUser(@PathVariable("uuid") UUID storyUUid, UserIdDto userIdDto) {
        storyService.setWasSeenForUserStory(userIdDto.getId(), storyUUid);
    }
}
