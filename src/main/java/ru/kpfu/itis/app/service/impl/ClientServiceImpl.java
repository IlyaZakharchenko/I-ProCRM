package ru.kpfu.itis.app.service.impl;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.app.model.Client;
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
    public List<Client> getAllClients() {
        return repo.findAll();
    }

    @Override
    public void addClient(String name, String phone, String email, String address) {
        Client client = Client.builder().fullName(name).phoneNumber(phone).email(email).address(address).build();
        repo.save(client);
    }
}
