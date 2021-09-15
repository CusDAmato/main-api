package ru.diamond.mainapi.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class UserDto {
    private final String id;

    private final String name;

    private final String country;

    private final String city;

    private final String email;

    private final Double wardrobeEfficiency;

    private final String avatarPath;

    @JsonCreator
    public UserDto(@JsonProperty("id") String id,
                   @JsonProperty("name") String name,
                   @JsonProperty("country") String country,
                   @JsonProperty("city") String city,
                   @JsonProperty("email") String email,
                   @JsonProperty("wardrobeEfficiency") Double wardrobeEfficiency,
                   @JsonProperty("avatarPath") String avatarPath) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
        this.email = email;
        this.wardrobeEfficiency = wardrobeEfficiency;
        this.avatarPath = avatarPath;
    }
}
