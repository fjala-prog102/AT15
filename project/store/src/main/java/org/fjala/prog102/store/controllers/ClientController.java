package org.fjala.prog102.store.controllers;

import java.util.List;

import org.fjala.prog102.store.models.Client;
import org.fjala.prog102.store.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    ClientServices clientServices;

    @GetMapping
    public List<Client> getClients() {
        return clientServices.getClients();
    }

    @PostMapping
    public Client saveClient(@RequestBody Client client) {
        return clientServices.saveClient(client);
    }
}
