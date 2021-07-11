package co.com.sofka.La35Street.domain.Purchase.commands;

import co.com.sofka.La35Street.domain.Purchase.values.*;
import co.com.sofka.domain.generic.Command;

public class AddProduct implements Command {
    private final ProductId productId;
    private final Brand brand;
    private final ProductPrice productPrice;
    private final ProductName productName;
    private final PurchaseId purchaseId;
    private final Image image;

    public AddProduct(ProductId productId, Brand brand,ProductPrice productPrice, ProductName productName, PurchaseId purchaseId, Image image) {
        this.productId = productId;
        this.brand = brand;
        this.productPrice = productPrice;
        this.productName = productName;
        this.purchaseId = purchaseId;
        this.image = image;
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

    public Image image(){
        return image;
    }
}
