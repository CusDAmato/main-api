package ru.diamond.mainapi.mappers;

import java.util.List;
import java.util.Set;
import org.mapstruct.Mapper;
import ru.diamond.mainapi.dtos.category.CategoryDto;
import ru.diamond.mainapi.entities.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDto toCategoryDto(Category category);
    List<CategoryDto> toCategoryDtoList(List<Category> categoryList);
    Set<CategoryDto> toCategoryDtoSet(Set<Category> categorySet);
}
