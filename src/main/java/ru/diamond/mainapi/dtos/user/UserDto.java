package ru.diamond.mainapi.dtos.user;

import lombok.Data;

@Data
public class UserDto {
    private final String id;
    private final String name;
    private final String country;
    private final String city;
    private final String email;
    private final Double wardrobeEfficiency;
    private final String avatarPath;
}
