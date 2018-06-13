package ru.kpfu.itis.app.service;

import ru.kpfu.itis.app.model.entities.News;

import java.util.List;

public interface NewsService {

    List<News> getAllNews();

    List<News> getTodayNews();
}
