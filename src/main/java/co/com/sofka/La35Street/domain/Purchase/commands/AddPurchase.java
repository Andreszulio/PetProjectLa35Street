package co.com.sofka.La35Street.domain.Purchase.commands;

import co.com.sofka.La35Street.domain.Purchase.Product;
import co.com.sofka.La35Street.domain.Purchase.values.*;
import co.com.sofka.domain.generic.Command;

import java.util.ArrayList;
import java.util.List;

public class AddPurchase implements Command {
    private final PurchaseId purchaseId;
    private final ClientId clientId;
    private final List<Product> productList;

    public AddPurchase(PurchaseId purchaseId, ClientId clientId, List<Product> productList) {
        this.purchaseId= purchaseId;
        this.clientId = clientId;
        this.productList = productList;
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
}
