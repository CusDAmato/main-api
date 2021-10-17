package ru.diamond.mainapi.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.diamond.mainapi.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
