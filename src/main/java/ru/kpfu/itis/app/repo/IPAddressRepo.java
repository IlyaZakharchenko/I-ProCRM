package ru.kpfu.itis.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.app.model.IPAddress;

public interface IPAddressRepo extends JpaRepository<IPAddress, Long> {
}
