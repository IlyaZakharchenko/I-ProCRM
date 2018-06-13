package ru.kpfu.itis.app.service.impl;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.app.model.entities.News;
import ru.kpfu.itis.app.repo.NewsRepo;
import ru.kpfu.itis.app.service.NewsService;

import java.util.Date;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    private NewsRepo repo;

    public NewsServiceImpl(NewsRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<News> getAllNews() {
        return repo.findAllByOrderByDateDesc();
    }

    @Override
    public List<News> getTodayNews() {
        return repo.findAllByDateEquals((new Date()));
    }
}
