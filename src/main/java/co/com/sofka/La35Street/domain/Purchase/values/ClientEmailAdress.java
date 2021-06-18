package co.com.sofka.La35Street.domain.Purchase.values;

import co.com.sofka.domain.generic.ValueObject;

public class ClientEmailAdress implements ValueObject<String> {
    private final String EmailAdress;

    public ClientEmailAdress(String EmailAdress){
        this.EmailAdress = EmailAdress;
    }

    @Override
    public String value(){
        return EmailAdress;
    }
}
