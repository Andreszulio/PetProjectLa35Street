package co.com.sofka.La35Street.domain.Purchase;

import co.com.sofka.La35Street.domain.Purchase.values.*;
import co.com.sofka.domain.generic.Entity;

public class Product extends Entity<ProductId> {
    private final Brand brand;
    private final ProductName productName;
    private final ProductPrice productPrice;

    public Product(ProductId entityId, Brand brand, ProductName productName, ProductPrice productPrice) {
        super(entityId);
        this.brand = brand;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public Brand Brand() {
        return brand;
    }

    public ProductName ProductName() {
        return productName;
    }

    public ProductPrice productPrice() {
        return productPrice;
    }
}
