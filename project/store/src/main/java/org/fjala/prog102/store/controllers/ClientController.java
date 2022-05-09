package org.fjala.prog102.store.controllers;

import java.util.List;

import org.fjala.prog102.store.models.Client;
import org.fjala.prog102.store.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientServices clientServices;

    @GetMapping
    public List<Client> getClients() {
        return clientServices.getClients();
    }

    @PostMapping
    public Client saveClient(@RequestBody Client client) {
        return clientServices.saveClient(client);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/{identificationNumber}")
    public String deleteClientById(@PathVariable("identificationNumber") Long identificationNumber) {
        boolean result = clientServices.deleteClientById(identificationNumber);
        if (!result) {
            return String.format("Client %s was deleted", identificationNumber);
        } else {
            return String.format("Client %s was not found", identificationNumber);
        }
    }
}
