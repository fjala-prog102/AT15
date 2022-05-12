package org.fjala.prog102.store.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.fjala.prog102.store.dto.RestResponseDto;
import org.fjala.prog102.store.exception.ResourceNotFoundException;
import org.fjala.prog102.store.models.Client;
import org.fjala.prog102.store.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/clients")
@Validated
public class ClientController {
    @Autowired
    private ClientServices clientServices;

    @GetMapping
    public RestResponseDto<List<Client>> getClients() {
        RestResponseDto<List<Client>> response = new RestResponseDto<>();
        response.setData(clientServices.getClients());
        return response;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RestResponseDto<Client> saveClient(@RequestBody Client client) {
        RestResponseDto<Client> response = new RestResponseDto<>();
        response.setData(clientServices.saveClient(client));
        return response;
    }

    @DeleteMapping("/delete/{identificationNumber}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@NotNull(message = "Client id cannot be empty")
                @PathVariable("identificationNumber") Long identificationNumber) {
        try {
            clientServices.deleteClient(identificationNumber);
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @GetMapping("/find/{identificationNumber}")
    public RestResponseDto<Optional<Client>> findClient(@NotNull(message = "A client identificationNumber must be specified")
                @PathVariable("identificationNumber") Long identificationNumber) {
        try {
            RestResponseDto<Optional<Client>> response = new RestResponseDto<>();
            response.setData(clientServices.findClient(identificationNumber));
            return response;
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @PutMapping("/find/{identificationNumber}")
    @ResponseStatus(HttpStatus.CREATED)
    public RestResponseDto<Client> updateClient(@RequestBody Client client) {
        RestResponseDto<Client> response = new RestResponseDto<>();
        response.setData(clientServices.saveClient(client));
        return response;
    }
}
