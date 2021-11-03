package ru.diamond.mainapi.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.diamond.mainapi.entities.nn.NnQueue;

public interface NnQueueRepository extends JpaRepository<UUID, NnQueue> {
}
