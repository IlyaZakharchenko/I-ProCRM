package ru.kpfu.itis.app.service;

import ru.kpfu.itis.app.model.Client;

import java.util.List;

public interface ClientService {

    List<Client> getAllClients();

    void addClient(String name, String phone, String email, String address);
}
