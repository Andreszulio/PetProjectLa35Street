package co.com.sofka.La35Street.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductDataRepository extends CrudRepository<ProductData, String> {
    Iterable<ProductData> findByPurchaseId(String purchaseId);
}
