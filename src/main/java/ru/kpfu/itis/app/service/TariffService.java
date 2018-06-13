package ru.kpfu.itis.app.service;

import ru.kpfu.itis.app.model.entities.Tariff;

import java.util.List;

public interface TariffService {
    List<Tariff> getAll();

    List<Tariff> filterByName(String name);
}
