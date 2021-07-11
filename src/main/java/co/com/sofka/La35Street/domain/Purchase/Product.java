package co.com.sofka.La35Street.domain.Purchase;

import co.com.sofka.La35Street.domain.Purchase.values.*;
import co.com.sofka.domain.generic.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Product")
public class Product extends Entity<ProductId> {

    private final Brand brand;
    private final ProductName productName;
    private final ProductPrice productPrice;
    private final PurchaseId purchaseId;
    private final Image image;

    public Product(ProductId entityId, Brand brand, ProductName productName, ProductPrice productPrice,PurchaseId purchaseId, Image image) {
        super(entityId);
        this.brand = brand;
        this.productName = productName;
        this.productPrice = productPrice;
        this.purchaseId = purchaseId;
        this.image = image;
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

    public PurchaseId PurchaseId() {
        return purchaseId;
    }

    public Image image(){
        return image;
    }

}
