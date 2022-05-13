package org.fjala.prog102.store.services;

import java.util.List;
import java.util.Optional;

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

    public Client saveClient(Client client) throws ResourceNotFoundException {
        if (client.getIdentificationNumber() != null) {
            return clientRepository.save(client);
        } else {
            throw new ResourceNotFoundException("A new client needs to have an identificationNumber");
        }
    }

    public void deleteClient(Long identificationNumber) throws ResourceNotFoundException {
        try {
            clientRepository.deleteById(identificationNumber);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Client identificationNumber was not found", e);
        }
    }

    public Optional<Client> findClient(Long identificationNumber) throws ResourceNotFoundException {
        if (clientRepository.existsById(identificationNumber)) {
            return clientRepository.findById(identificationNumber);
        } else {
            throw new ResourceNotFoundException("Client identificationNumber was not found");
        }
    }

    public Client updateClient(Client client) throws ResourceNotFoundException {
        if (clientRepository.existsById(client.getIdentificationNumber())) {
            return clientRepository.saveAndFlush(client);
        } else {
            throw new ResourceNotFoundException("The provided Client doesn't exist");
        }
    }
}
