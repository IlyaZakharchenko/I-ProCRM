package ru.kpfu.itis.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.app.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
}
