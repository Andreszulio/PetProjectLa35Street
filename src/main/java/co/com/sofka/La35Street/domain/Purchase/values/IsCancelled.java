package co.com.sofka.La35Street.domain.Purchase.values;

import co.com.sofka.domain.generic.ValueObject;

public class IsCancelled implements ValueObject<Boolean> {
    private final Boolean Cancelled;

    public IsCancelled(Boolean Cancelled){
        this.Cancelled = Cancelled;
    }

    @Override
    public Boolean value() {
        return Cancelled;

    }
}
