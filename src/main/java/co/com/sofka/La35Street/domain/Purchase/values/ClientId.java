package co.com.sofka.La35Street.domain.Purchase.values;

import co.com.sofka.domain.generic.Identity;

public class ClientId extends Identity {
    public ClientId(String uuid){
        super(uuid);
    }
    public static ClientId of(String uuid){
        return new ClientId(uuid);
    }
}