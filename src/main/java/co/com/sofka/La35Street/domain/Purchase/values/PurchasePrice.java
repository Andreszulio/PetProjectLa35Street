package co.com.sofka.La35Street.domain.Purchase.values;

import co.com.sofka.domain.generic.ValueObject;

public class PurchasePrice implements ValueObject <Integer>{
    private final Integer value;

    public PurchasePrice(Integer value){
        if (value < 0){
            throw new IllegalArgumentException("You can't put a negative price");
        }
        this.value = value;
    }
    @Override
    public Integer value(){
        return value;
    }
}
