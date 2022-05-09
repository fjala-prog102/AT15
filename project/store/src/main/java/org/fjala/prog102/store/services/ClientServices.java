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

    public boolean deleteClientById(Long identificationNumber) {
        try {
            ClientRepository.deleteClientById(identificationNumber);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
