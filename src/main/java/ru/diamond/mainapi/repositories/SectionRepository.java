package ru.diamond.mainapi.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.diamond.mainapi.entities.Section;

@Repository
public interface SectionRepository extends JpaRepository<Section, Integer> {

    @Query("from Section s join s.categories")
    List<Section> findAllWithCategories();
}
