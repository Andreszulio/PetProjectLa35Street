package co.com.sofka.La35Street.domain.Purchase;

import co.com.sofka.La35Street.domain.Purchase.events.PurchaseCreated;
import co.com.sofka.domain.generic.EventChange;

import java.util.ArrayList;

public class PurchaseChanges extends EventChange {
    public PurchaseChanges(Purchase purchase) {
        apply((PurchaseCreated event)->{
            purchase.product = new ArrayList<>();
            purchase.purchaseDate = event.PurchaseDate();
            purchase.purchasePrice = event.PurchasePrice();
            purchase.clientId = event.clientId();
        });
    }
}
