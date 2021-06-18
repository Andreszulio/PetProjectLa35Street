package co.com.sofka.La35Street.domain.Purchase.events;

import co.com.sofka.La35Street.domain.Purchase.values.IsCancelled;
import co.com.sofka.La35Street.domain.Purchase.values.PurchaseId;
import co.com.sofka.domain.generic.DomainEvent;

public class PurchaseCancelled extends DomainEvent {
    private final IsCancelled cancelled;

    public PurchaseCancelled(IsCancelled cancelled){
        super("La35Street.Purchase.Cancelled");
        this.cancelled = cancelled;
        aggregateRootId();
    }

    public IsCancelled Cancelled() {
        return cancelled;
    }
    public PurchaseId purchaseId(){
        return PurchaseId.of(aggregateRootId());
    }
}
