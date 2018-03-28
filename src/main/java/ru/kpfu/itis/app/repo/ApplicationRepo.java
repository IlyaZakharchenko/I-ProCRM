package ru.kpfu.itis.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.app.model.Application;

public interface ApplicationRepo extends JpaRepository<Application, Long> {
}
