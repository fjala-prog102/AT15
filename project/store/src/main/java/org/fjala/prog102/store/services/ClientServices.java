package org.fjala.prog102.store.services;

import java.util.List;

import org.fjala.prog102.store.models.Client;
import org.fjala.prog102.store.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServices {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getClients() {
        return (List<Client>) clientRepository.findAll();
    }

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    public void deleteClient(Client client) {
        clientRepository.delete(client);
    }

    public Client findClient(Client client) {
        return clientRepository.findById(client.getIdentificationNumber()).orElse(null);
    }
}
