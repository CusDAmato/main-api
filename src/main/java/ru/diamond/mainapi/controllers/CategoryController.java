package ru.diamond.mainapi.controllers;

import java.util.Set;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.diamond.mainapi.dtos.category.SectionCategoryDto;
import ru.diamond.mainapi.services.CategoryService;

@AllArgsConstructor
@RequestMapping(path = "/categories")
@RestController
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public Set<SectionCategoryDto> getAllCategoriesWithSections() {
        return categoryService.getCategoriesBySection();
    }
}
