package co.com.sofka.La35Street.domain.Purchase.commands;

import co.com.sofka.La35Street.domain.Purchase.values.IsCancelled;
import co.com.sofka.La35Street.domain.Purchase.values.PurchaseId;
import co.com.sofka.domain.generic.Command;

public class CancellPurchase implements Command {
    private final PurchaseId purchaseId;
    private final IsCancelled isCancelled;

    public CancellPurchase(PurchaseId purchaseId, IsCancelled isCancelled) {
        this.purchaseId = purchaseId;
        this.isCancelled = isCancelled;
    }

    public PurchaseId PurchaseId() {
        return purchaseId;
    }

    public IsCancelled isCancelled() {
        return isCancelled();
    }
}
