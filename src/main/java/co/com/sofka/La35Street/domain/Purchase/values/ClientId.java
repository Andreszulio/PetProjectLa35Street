package co.com.sofka.La35Street.domain.Purchase.values;

import co.com.sofka.domain.generic.Identity;

public class ClientId extends Identity {
    public ClientId(String id){
        super(id);
    }
    public static ClientId of(String id){
        return new ClientId(id);
    }
}