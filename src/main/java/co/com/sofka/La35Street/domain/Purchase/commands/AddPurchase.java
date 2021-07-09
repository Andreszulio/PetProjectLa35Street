package co.com.sofka.La35Street.domain.Purchase.commands;

import co.com.sofka.La35Street.domain.Purchase.Product;
import co.com.sofka.La35Street.domain.Purchase.values.*;
import co.com.sofka.domain.generic.Command;

import java.util.ArrayList;
import java.util.List;

public class AddPurchase implements Command {
    private final PurchaseId purchaseId;
    private final PurchaseDate purchaseDate;
    private final ClientId clientId;
    private final List<Product> productList;

    public AddPurchase(PurchaseId purchaseId, ClientId clientId) {
        this.purchaseId= purchaseId;
        this.purchaseDate = new PurchaseDate();
        this.clientId = clientId;
        this.productList = new ArrayList<>();
    }

    public PurchaseId PurchaseId() {
        return purchaseId;
    }

    public ClientId ClientId(){
        return clientId;
    }

    public List<Product> ProductList() {
        return productList;
    }

    public PurchaseDate PurchaseDate() {
        return purchaseDate;
    }

}
