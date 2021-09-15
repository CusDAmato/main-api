package ru.diamond.mainapi.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.diamond.mainapi.dtos.ClothesDto;
import ru.diamond.mainapi.entities.Clothes;
import ru.diamond.mainapi.entities.User;
import ru.diamond.mainapi.enums.PartsOfTheDay;
import ru.diamond.mainapi.mappers.ClothesMapper;
import ru.diamond.mainapi.repositories.ClothesRepository;
import ru.diamond.mainapi.repositories.UserRepository;

@Service
@AllArgsConstructor
public class ClothesService {
    private final UserRepository userRepository;
    private final ClothesRepository clothesRepository;
    private final ObjectMapper objectMapper;
    private final ClothesMapper clothesMapper;

    // List<List<UUID>> to List<List<ClothesDto>>
    public Map<PartsOfTheDay, List<List<ClothesDto>>> getFittedOutfit(UUID userUuid) {
        User user = userRepository.getById(userUuid);
        Map<PartsOfTheDay, List<List<UUID>>> fittedOutfit =
                objectMapper.convertValue(user.getFittedOutfit(), Map.class);

        List<UUID> clothesUuids = fittedOutfit.values().stream()
                .map(e -> e.stream()
                        .flatMap(List::stream)
                        .collect(Collectors.toList()))
                .flatMap(List::stream)
                .collect(Collectors.toList());
        Map<UUID, ClothesDto> clothesDtoUuidsMap = clothesRepository.findAllById(clothesUuids).stream()
                .collect(Collectors.toMap(Clothes::getUuid, clothesMapper::toDto));

        return fittedOutfit.entrySet().stream()
                .collect(Collectors.toMap(Entry::getKey, e ->
                    e.getValue().stream().map(list ->
                        list.stream().map(clothesDtoUuidsMap::get).collect(Collectors.toList())
                    ).collect(Collectors.toList())
                ));

    }
}
