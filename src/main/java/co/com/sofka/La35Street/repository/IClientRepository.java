package co.com.sofka.La35Street.repository;

import co.com.sofka.La35Street.domain.Purchase.Client;
import co.com.sofka.La35Street.domain.Purchase.values.ClientId;
import org.springframework.data.repository.CrudRepository;

public interface IClientRepository extends CrudRepository<Client, ClientId> {

}
