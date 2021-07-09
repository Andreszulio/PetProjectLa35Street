package co.com.sofka.La35Street.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientDataRepository extends CrudRepository<ClientData, String> {

}
