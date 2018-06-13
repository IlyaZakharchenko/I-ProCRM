package ru.kpfu.itis.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.app.model.entities.Tariff;
import ru.kpfu.itis.app.service.TariffService;

import java.util.List;

@Controller
public class TariffsController {

    private TariffService service;

    public TariffsController(TariffService service) {
        this.service = service;
    }

    @PostMapping(value = "/tariffs/search/ajax")
    public ResponseEntity getNews(@RequestBody String search) {
        search = search.substring(1, search.length() - 1);
        List<Tariff> tariffList = service.filterByName(search);
        return ResponseEntity.ok(tariffList);
    }

    @GetMapping(value = "/tariffs")
    public String getAllTariffs(Model model) {
        model.addAttribute("tariffs", service.getAll());
        return "tariff";
    }
}
