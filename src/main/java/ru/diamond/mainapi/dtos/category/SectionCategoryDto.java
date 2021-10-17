package ru.diamond.mainapi.dtos.category;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SectionCategoryDto {
    private SectionDto section;
    private Set<CategoryDto> categories;
}
