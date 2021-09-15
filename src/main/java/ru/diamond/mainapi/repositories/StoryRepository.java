package ru.diamond.mainapi.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.diamond.mainapi.entities.Story;

@Repository
public interface StoryRepository extends JpaRepository<Story, UUID> {
}
