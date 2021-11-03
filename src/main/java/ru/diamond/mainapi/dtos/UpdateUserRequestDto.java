package ru.diamond.mainapi.dtos;

import lombok.Data;

@Data
public class UpdateUserRequestDto {
    private String name;
    private String country;
    private String city;
    private String email;
    private Double wardrobeEfficiency;
    private String avatarPath;
}
