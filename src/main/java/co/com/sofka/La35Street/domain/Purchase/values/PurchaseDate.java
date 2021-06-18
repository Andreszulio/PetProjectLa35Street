package co.com.sofka.La35Street.domain.Purchase.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDateTime;

public class PurchaseDate implements ValueObject<LocalDateTime> {
    private final LocalDateTime value;

    public PurchaseDate(){
        this.value = LocalDateTime.now();
    }

    @Override
    public LocalDateTime value(){
        return value;
    }

}
