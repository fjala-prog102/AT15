package org.fjala.prog102.store.services;

import java.util.List;

import org.fjala.prog102.store.exception.ResourceNotFoundException;
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

    public void deleteClientByIdentificationNumber(Client client) throws ResourceNotFoundException {
        try {
            clientRepository.delete(client);
        } catch (Exception e) {
            throw new ResourceNotFoundException(String.format("Client %s was not found", client.getIdentificationNumber()), e);
        }
    }

    public Client findClientByIdentificationNumber(Client client) throws ResourceNotFoundException {
        try {
            return clientRepository.findById(client.getIdentificationNumber()).orElse(null);
        } catch (Exception e) {
            throw new ResourceNotFoundException(String.format("Client %s was not found", client.getIdentificationNumber()), e);
        }
    }
}
