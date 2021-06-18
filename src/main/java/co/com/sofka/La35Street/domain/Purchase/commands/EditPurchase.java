package co.com.sofka.La35Street.domain.Purchase.commands;

import co.com.sofka.La35Street.domain.Purchase.Product;
import co.com.sofka.La35Street.domain.Purchase.values.PurchaseId;
import co.com.sofka.domain.generic.Command;

import java.util.List;

public class EditPurchase implements Command {
    private final PurchaseId purchaseId;
    private final List<Product> product;

    public EditPurchase(PurchaseId purchaseId, List<Product> product) {
        this.purchaseId = purchaseId;
        this.product = product;
    }

    public PurchaseId PurchaseId() {
        return purchaseId;
    }

    public List<Product> Product() {
        return product;
    }
}
