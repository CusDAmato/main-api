package ru.diamond.mainapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.diamond.mainapi.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query("from User u join u.stories us join us.story where u.id = :id")
    User findAllAboutUser(String id);
}
