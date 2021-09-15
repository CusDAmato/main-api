package ru.diamond.mainapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.diamond.mainapi.entities.Print;

@Repository
public interface PrintRepository extends JpaRepository<Print, Integer> {
}
