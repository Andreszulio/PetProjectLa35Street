package co.com.sofka.La35Street.domain.Purchase;

import co.com.sofka.La35Street.domain.Purchase.values.*;
import co.com.sofka.domain.generic.AggregateRoot;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.List;

@Document(collation = "Purchase")
public class Purchase extends AggregateRoot<PurchaseId> {

    protected PurchasePrice purchasePrice;
    protected PurchaseDate purchaseDate;
    protected ClientId clientId;
    protected List<Product> product;
    protected IsCancelled cancelled;

    public Purchase(PurchaseId purchaseId, PurchasePrice purchasePrice, PurchaseDate purchaseDate, ClientId clientId, List<Product> product, IsCancelled cancelled) {
        super(purchaseId);
        this.purchasePrice = purchasePrice;
        this.purchaseDate = purchaseDate;
        this.clientId = clientId;
        this.product = product;
        this.cancelled = cancelled;
    }

    public PurchasePrice PurchasePrice() {
        return purchasePrice;
    }

    public PurchaseDate PurchaseDate() {
        return purchaseDate;
    }

    public ClientId ClientId() {
        return clientId;
    }

    public List<Product> Product() {
        return product;
    }

    public IsCancelled Cancelled() {
        return cancelled;
    }
}
