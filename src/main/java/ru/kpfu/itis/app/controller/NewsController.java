package ru.kpfu.itis.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.app.service.NewsService;

@Controller
public class NewsController {

    private NewsService service;

    public NewsController(NewsService service) {
        this.service = service;
    }

    @PostMapping(value = "/news")
    public String getNews(@RequestParam String select, Model model) {
        model.addAttribute("select", select);
        if (select.equals("Все")) {
            model.addAttribute("news", service.getAllNews());
        }
        else {
            model.addAttribute("news", service.getTodayNews());
        }
        return "news";
    }

    @GetMapping(value = "/news")
    public String getAllNews(Model model) {
        model.addAttribute("news", service.getAllNews());
        return "news";
    }

    @GetMapping(value = "/")
    public String redirectToMain() {
        return "redirect:/news";
    }
}
