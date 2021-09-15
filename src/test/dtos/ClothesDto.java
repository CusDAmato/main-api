package ru.diamond.mainapi.dtos;

import java.util.UUID;
import lombok.Data;

@Data
public class ClothesDto {
    private UUID uuid;
    private String imgPath;
    private String section;
    private String category;
    private String color;
    private String print;
}
