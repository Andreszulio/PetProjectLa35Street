package co.com.sofka.La35Street.repository;

import co.com.sofka.La35Street.domain.Purchase.Product;
import co.com.sofka.La35Street.domain.Purchase.values.ProductId;
import org.springframework.data.repository.CrudRepository;

public interface IProductRepository extends CrudRepository<Product, ProductId> {

}
