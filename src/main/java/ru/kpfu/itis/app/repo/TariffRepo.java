package ru.kpfu.itis.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.app.model.Tariff;

public interface TariffRepo extends JpaRepository<Tariff, Long> {
}
