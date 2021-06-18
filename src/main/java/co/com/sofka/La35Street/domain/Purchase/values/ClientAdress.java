package co.com.sofka.La35Street.domain.Purchase.values;

import co.com.sofka.domain.generic.ValueObject;

public class ClientAdress implements ValueObject<String> {
    private final String Adress;

    public ClientAdress(String Adress){
        this.Adress = Adress;
    }

    @Override
    public String value(){
        return Adress;
    }
}
