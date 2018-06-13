package ru.kpfu.itis.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.app.model.entities.Client;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {

}
