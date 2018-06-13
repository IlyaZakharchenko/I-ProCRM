package ru.kpfu.itis.app.service.impl;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.app.model.entities.Client;
import ru.kpfu.itis.app.repo.ClientRepo;
import ru.kpfu.itis.app.service.ClientService;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepo repo;

    public ClientServiceImpl(ClientRepo repo) {
        this.repo = repo;
    }

    @Override
    public void addClient(Client c) {
        repo.save(c);
    }

    @Override
    public List<Client> getAllClients() {
        return repo.findAll();
    }
}
