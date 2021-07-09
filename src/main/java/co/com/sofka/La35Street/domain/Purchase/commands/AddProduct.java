package co.com.sofka.La35Street.domain.Purchase.commands;

import co.com.sofka.La35Street.domain.Purchase.values.*;
import co.com.sofka.domain.generic.Command;

public class AddProduct implements Command {
    private final ProductId productId;
    private final Brand brand;
    private final ProductPrice productPrice;
    private final ProductName productName;
    private final PurchaseId purchaseId;

    public AddProduct(ProductId productId, Brand brand,ProductPrice productPrice, ProductName productName, PurchaseId purchaseId) {
        this.productId = productId;
        this.brand = brand;
        this.productPrice = productPrice;
        this.productName = productName;
        this.purchaseId = purchaseId;
    }

    public ProductId ProductId() {
        return productId;
    }

    public Brand Brand() {
        return brand;
    }

    public ProductPrice ProductPrice(){
        return productPrice;
    }

    public ProductName ProductName() {
        return productName;
    }

    public PurchaseId PurchaseId(){
        return purchaseId;
    }
}
