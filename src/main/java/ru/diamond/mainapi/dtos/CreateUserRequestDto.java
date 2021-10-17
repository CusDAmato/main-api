package ru.diamond.mainapi.dtos;

import lombok.Data;

@Data
public class CreateUserRequestDto {
    private String name;
    private String email;
}
