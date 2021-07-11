package co.com.sofka.La35Street.domain.Purchase.values;

import co.com.sofka.domain.generic.ValueObject;

public class Rol implements ValueObject<String> {
private final String rol;

    public Rol(String rol){
        this.rol = rol;
    }

    @Override
    public String value(){
        return rol;
    }
}
