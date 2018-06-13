package ru.kpfu.itis.app.service.impl;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.app.model.entities.Tariff;
import ru.kpfu.itis.app.repo.TariffRepo;
import ru.kpfu.itis.app.service.TariffService;

import java.util.List;

@Service
public class TariffServiceImpl implements TariffService {

    private TariffRepo repo;

    public TariffServiceImpl(TariffRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<Tariff> getAll() {
        return repo.findAll();
    }

    @Override
    public List<Tariff> filterByName(String name) {
        return repo.getAllByNameLike(name + "%");
    }
}
