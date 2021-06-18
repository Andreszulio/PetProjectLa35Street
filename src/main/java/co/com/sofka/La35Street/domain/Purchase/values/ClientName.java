package co.com.sofka.La35Street.domain.Purchase.values;

import co.com.sofka.domain.generic.ValueObject;

public class ClientName implements ValueObject<String> {
    private final String Name;

    public ClientName(String Name){
        this.Name = Name;
    }

    @Override
    public String value(){
        return Name;
    }
}
