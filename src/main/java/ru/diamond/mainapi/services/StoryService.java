package ru.diamond.mainapi.services;

import java.util.UUID;
import javax.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.diamond.mainapi.entities.Story;
import ru.diamond.mainapi.entities.User;
import ru.diamond.mainapi.entities.UserStory;
import ru.diamond.mainapi.exceptions.EntityDoesNotExistException;
import ru.diamond.mainapi.utils.fi.Function2;

@Service
@AllArgsConstructor
public class StoryService {

    public static final Function2<String, UUID, EntityDoesNotExistException> STORY_NOT_FOUND_FOR_USER =
            (userId, storyUuid) ->
                    new EntityDoesNotExistException(
                            "Story with uuid=" + storyUuid + " was not found for user with id=" + userId);

    private final UserService userService;
    private final EntityManager entityManager;

    public void setWasSeenForUserStory(String userId, UUID storyUuid) {
        UserStory userStory = getUserStory(userId, storyUuid);
        userStory.setWasSeen(true);
        entityManager.merge(userStory);
        entityManager.flush();
    }

    public UserStory getUserStory(String userId, UUID storyUuid) {
        User user = userService.getUser(userId);
        return user.getStories().stream()
                .filter(userStory -> userStory.getStory().getUuid().equals(storyUuid))
                .findAny()
                .orElseThrow(() -> STORY_NOT_FOUND_FOR_USER.apply(userId, storyUuid));
    }
}
