package ru.kpfu.itis.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.app.model.File;

public interface FileRepo extends JpaRepository<File, Long> {
}
