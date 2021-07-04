package co.com.sofka.La35Street.domain.Purchase;

import co.com.sofka.La35Street.domain.Purchase.values.*;
import co.com.sofka.domain.generic.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Product")
public class Product extends Entity<ProductId> {

    @Id
    private String id;

    private final Brand brand;
    private final ProductName productName;
    private final ProductPrice productPrice;
    private final PurchaseId purchaseId;

    public Product(ProductId entityId, Brand brand, ProductName productName, ProductPrice productPrice,PurchaseId purchaseId) {
        super(entityId);
        this.id = entityId.value();
        this.brand = brand;
        this.productName = productName;
        this.productPrice = productPrice;
        this.purchaseId = purchaseId;
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

    public String Id() {
        return id;
    }

    public void Id(String id) {
        this.id = id;
    }

    public PurchaseId PurchaseId() {
        return purchaseId;
    }
}
