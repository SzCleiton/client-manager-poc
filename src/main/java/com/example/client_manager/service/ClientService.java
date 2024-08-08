package com.example.client_manager.service;

import com.example.client_manager.model.Client;
import com.example.client_manager.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client salvar(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> listarTodos() {
        return clientRepository.findAll();
    }
}
