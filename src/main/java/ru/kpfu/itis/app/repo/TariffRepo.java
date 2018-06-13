package ru.kpfu.itis.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.app.model.entities.Tariff;

import java.util.List;

public interface TariffRepo extends JpaRepository<Tariff, Long> {

    List<Tariff> getAllByNameLike(String name);
}
