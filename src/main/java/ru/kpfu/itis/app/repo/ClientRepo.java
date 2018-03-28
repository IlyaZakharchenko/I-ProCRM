package ru.kpfu.itis.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.app.model.Client;

public interface ClientRepo extends JpaRepository<Client, Long> {
}
