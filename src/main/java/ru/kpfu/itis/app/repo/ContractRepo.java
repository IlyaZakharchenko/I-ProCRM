package ru.kpfu.itis.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.app.model.Contract;

public interface ContractRepo extends JpaRepository<Contract, Long> {
}
