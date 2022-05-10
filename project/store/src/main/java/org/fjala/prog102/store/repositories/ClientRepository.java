package org.fjala.prog102.store.repositories;

import org.fjala.prog102.store.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findClientByIdentificationNumber(Long identificationNumber);

    void deleteClientByIdentificationNumber(Client client);
}
