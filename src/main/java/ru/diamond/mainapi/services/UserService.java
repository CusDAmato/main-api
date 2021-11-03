package ru.diamond.mainapi.services;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.diamond.mainapi.dtos.CreateUserRequestDto;
import ru.diamond.mainapi.dtos.UpdateUserRequestDto;
import ru.diamond.mainapi.dtos.main.MainWindowDto;
import ru.diamond.mainapi.dtos.story.StoryDto;
import ru.diamond.mainapi.dtos.user.UserDto;
import ru.diamond.mainapi.entities.User;
import ru.diamond.mainapi.exceptions.EntityDoesNotExistException;
import ru.diamond.mainapi.mappers.StoryMapper;
import ru.diamond.mainapi.mappers.UserMapper;
import ru.diamond.mainapi.repositories.UserRepository;

@AllArgsConstructor
@Service
public class UserService {

    public static final Function<String, EntityDoesNotExistException> USER_NOT_FOUND_FOR_ID = id ->
            new EntityDoesNotExistException("User was not found for id=" + id);

    private final UserMapper userMapper;
    private final StoryMapper storyMapper;
    private final UserRepository userRepository;

    public UserDto createUser(String id, CreateUserRequestDto requestDto) {
        User user = User.builder()
                .id(id)
                .name(requestDto.getName())
                .email(requestDto.getEmail()).build();
        userRepository.save(user);
        return userMapper.toUserDto(user);
    }

    public UserDto updateUser(String id, UpdateUserRequestDto requestDto) {
        User user = getUser(id);
        user.setName(requestDto.getName());
        user.setCountry(requestDto.getCountry());
        user.setCity(requestDto.getCity());
        user.setEmail(requestDto.getEmail());
        user.setWardrobeEfficiency(requestDto.getWardrobeEfficiency());
        user.setAvatarPath(requestDto.getAvatarPath());
        userRepository.save(user);
        return userMapper.toUserDto(user);
    }

    public User getUser(String id) {
        return userRepository.findById(id).orElseThrow(() -> USER_NOT_FOUND_FOR_ID.apply(id));
    }

    public MainWindowDto getUserForMainWindow(String id) {
        User user = userRepository.findAllAboutUser(id);
        if (user == null) {
            throw USER_NOT_FOUND_FOR_ID.apply(id);
        }
        UserDto userDto = userMapper.toUserDto(user);
        Set<StoryDto> storyDtoSet = user.getStories().stream()
                .map(userStory -> {
                    StoryDto storyDto = storyMapper.toStoryDto(userStory.getStory());
                    storyDto.setWasSeen(storyDto.isWasSeen());
                    return storyDto;
                })
                .collect(Collectors.toSet());

        return new MainWindowDto(userDto, user.getFittedOutfit(), storyDtoSet);
    }
}
