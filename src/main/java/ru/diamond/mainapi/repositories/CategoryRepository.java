package ru.diamond.mainapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.diamond.mainapi.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
