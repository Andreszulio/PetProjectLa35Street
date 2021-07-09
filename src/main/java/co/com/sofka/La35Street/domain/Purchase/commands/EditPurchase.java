package co.com.sofka.La35Street.domain.Purchase.commands;

import co.com.sofka.La35Street.domain.Purchase.values.*;
import co.com.sofka.domain.generic.Command;


public class EditPurchase implements Command {
    private final PurchaseId purchaseId;
    private final PurchaseDate purchaseDate;
    private final ClientId clientId;

    public EditPurchase(PurchaseId purchaseId, ClientId clientId) {
        this.purchaseId = purchaseId;
        this.purchaseDate = new PurchaseDate();
        this.clientId = clientId;

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


}
