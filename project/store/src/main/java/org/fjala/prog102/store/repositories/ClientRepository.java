package org.fjala.prog102.store.repositories;

import org.fjala.prog102.store.models.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long>{

}
