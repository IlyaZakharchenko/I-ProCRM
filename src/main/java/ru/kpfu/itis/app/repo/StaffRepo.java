package ru.kpfu.itis.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.app.model.entities.Staff;

public interface StaffRepo extends JpaRepository<Staff, Long> {
}
