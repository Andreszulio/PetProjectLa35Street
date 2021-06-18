package co.com.sofka.La35Street.domain.Purchase.events;

import co.com.sofka.La35Street.domain.Purchase.Product;
import co.com.sofka.La35Street.domain.Purchase.commands.EditPurchase;
import co.com.sofka.La35Street.domain.Purchase.values.PurchasePrice;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class PurchaseEdited extends DomainEvent {
    private final List<Product> product;
    private final PurchasePrice purchasePrice;

    public PurchaseEdited(List<Product> product, PurchasePrice price) {
        super("La35Street.Purchase.Edited");
        this.product = product;
        this.purchasePrice = price;
        aggregateRootId();
    }

    public List<Product> Product() {
        return product;
    }

    public PurchasePrice PurchasePrice() {
        return purchasePrice;
    }
}
