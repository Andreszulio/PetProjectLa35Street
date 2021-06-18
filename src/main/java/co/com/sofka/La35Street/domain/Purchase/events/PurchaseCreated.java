package co.com.sofka.La35Street.domain.Purchase.events;

import co.com.sofka.La35Street.domain.Purchase.values.*;
import co.com.sofka.domain.generic.DomainEvent;

public class PurchaseCreated extends DomainEvent {
    private final ProductId productId;
    private final Brand brand;
    private final PurchasePrice purchasePrice;
    private final PurchaseDate purchaseDate;
    private final ClientId clientId;
    private final ClientName clientName;


    public PurchaseCreated(ProductId productId, Brand brand, PurchasePrice purchasePrice, PurchaseDate purchaseDate, ClientId clientId, ClientName clientName) {
        super("La35Street.Purchase.Created");
        this.productId = productId;
        this.brand = brand;
        this.purchasePrice = purchasePrice;
        this.purchaseDate = purchaseDate;
        this.clientId = clientId;
        this.clientName = clientName;
        aggregateRootId();
    }

    public ProductId ProductId() {
        return productId;
    }


    public Brand Brand() {
        return brand;
    }

    public PurchasePrice PurchasePrice() {
        return purchasePrice;
    }

    public PurchaseDate PurchaseDate() {
        return purchaseDate;
    }
    public ClientId clientId(){
        return clientId;
    }
    public ClientName clientName(){
        return clientName;
    }
}
