package co.com.sofka.La35Street.domain.Purchase.commands;

import co.com.sofka.La35Street.domain.Purchase.Product;
import co.com.sofka.La35Street.domain.Purchase.values.*;
import co.com.sofka.domain.generic.Command;

import java.util.List;

public class EditPurchase implements Command {
    private final PurchaseId purchaseId;
    private final PurchaseDate purchaseDate;
    private final ClientId clientId;
    private final List<Product> product;

    public EditPurchase(PurchaseId purchaseId, ClientId clientId, List<Product> product) {
        this.purchaseId = purchaseId;
        this.purchaseDate = new PurchaseDate();
        this.clientId = clientId;
        this.product = product;

    }

    public PurchaseId PurchaseId() {
        return purchaseId;
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
