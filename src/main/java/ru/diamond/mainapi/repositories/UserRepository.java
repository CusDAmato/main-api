package ru.diamond.mainapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.diamond.mainapi.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
