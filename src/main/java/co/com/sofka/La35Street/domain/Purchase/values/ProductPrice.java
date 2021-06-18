package co.com.sofka.La35Street.domain.Purchase.values;

import co.com.sofka.domain.generic.ValueObject;

public class ProductPrice implements ValueObject<Integer> {
    private final Integer value;

    public ProductPrice(Integer value){
        this.value = value;
    }

    @Override
    public Integer value() {
        return value;
    }
}
