package co.com.sofka.La35Street.repository;

import co.com.sofka.La35Street.domain.Purchase.Purchase;
import co.com.sofka.La35Street.domain.Purchase.values.PurchaseId;
import org.springframework.data.repository.CrudRepository;

public interface IPurchaseRepository extends CrudRepository<Purchase,PurchaseId> {

}
