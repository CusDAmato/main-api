package ru.diamond.mainapi.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateUserRequestDto {
    private String name;
    private String email;
}
