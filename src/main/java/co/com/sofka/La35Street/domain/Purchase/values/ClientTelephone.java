package co.com.sofka.La35Street.domain.Purchase.values;

import co.com.sofka.domain.generic.ValueObject;

public class ClientTelephone implements ValueObject<String> {
    private final String Telephone;

    public ClientTelephone(String Telephone){
        this.Telephone = Telephone;
    }

    @Override
    public String value(){
        return Telephone;
    }
}
