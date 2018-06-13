package ru.kpfu.itis.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.app.model.entities.News;

import java.util.Date;
import java.util.List;

public interface NewsRepo extends JpaRepository<News, Long> {

    List<News> findAllByDateEquals(Date date);

    List<News> findAllByOrderByDateDesc();
}
