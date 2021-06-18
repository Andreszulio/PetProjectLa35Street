package co.com.sofka.La35Street.domain.Purchase.events;

import co.com.sofka.La35Street.domain.Purchase.values.Brand;
import co.com.sofka.La35Street.domain.Purchase.values.ProductName;
import co.com.sofka.La35Street.domain.Purchase.values.ProductPrice;
import co.com.sofka.La35Street.domain.Purchase.values.PurchasePrice;
import co.com.sofka.domain.generic.DomainEvent;


public class AggregateProduct extends DomainEvent {
    private final ProductPrice productPrice;
    private final Brand brand;
    private final ProductName productName;

    public AggregateProduct(ProductPrice productPrice, Brand brand, ProductName productName) {
        super("La35Street.Product.Created");
        this.productPrice = productPrice;
        this.brand = brand;
        this.productName = productName;
        aggregateRootId();
    }

    public ProductPrice productPrice() {
        return productPrice;
    }

    public Brand Brand() {
        return brand;
    }

    public ProductName ProductName() {
        return productName;
    }
}
