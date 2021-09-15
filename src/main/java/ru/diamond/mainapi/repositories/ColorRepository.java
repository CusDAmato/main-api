package ru.diamond.mainapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.diamond.mainapi.entities.Color;

@Repository
public interface ColorRepository extends JpaRepository<Color, Integer> {
}
