package ru.kpfu.itis.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.app.model.entities.AppUser;

import java.util.Optional;

public interface UserRepo extends JpaRepository<AppUser, Long> {
    Optional<AppUser> getOneByLogin(String login);
    Optional<AppUser> getOneByUid(String uid);
}
