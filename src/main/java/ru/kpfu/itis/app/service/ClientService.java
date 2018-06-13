package ru.kpfu.itis.app.service;

import ru.kpfu.itis.app.model.entities.Client;

import java.util.List;

public interface ClientService {

    void addClient(Client c);

    List<Client> getAllClients();
}
