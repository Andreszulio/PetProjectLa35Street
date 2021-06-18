package co.com.sofka.La35Street.domain.Purchase.values;

import co.com.sofka.domain.generic.ValueObject;

public class Brand implements ValueObject<String> {
    private final String value;

    public Brand(String value){
        this.value = value;
    }

    @Override
    public String value(){
        return value;
    }
}
