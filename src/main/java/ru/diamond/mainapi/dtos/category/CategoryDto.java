package ru.diamond.mainapi.dtos.category;

import lombok.Data;

@Data
public class CategoryDto {
    private Integer id;
    private String code;
    private String description;
}
