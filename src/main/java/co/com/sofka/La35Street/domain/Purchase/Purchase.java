package co.com.sofka.La35Street.domain.Purchase;

import co.com.sofka.La35Street.domain.Purchase.values.*;
import co.com.sofka.domain.generic.AggregateRoot;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.List;

@Document(collection = "Purchase")
public class Purchase extends AggregateRoot<PurchaseId> {

    @Id
    protected String id;

    protected PurchasePrice purchasePrice;
    protected PurchaseDate purchaseDate;
    protected ClientId clientId;
    protected List<Product> product;

    public Purchase(PurchaseId purchaseId, PurchasePrice purchasePrice, PurchaseDate purchaseDate, ClientId clientId, List<Product> product) {
        super(purchaseId);
        this.id = purchaseId.value();
        this.purchasePrice = purchasePrice;
        this.purchaseDate = purchaseDate;
        this.clientId = clientId;
        this.product = product;
    }

    public void Id(String id) {
        this.id = id;
    }

    public String Id() {
        return id;
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

}
