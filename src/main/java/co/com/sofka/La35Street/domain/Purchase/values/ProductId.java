package co.com.sofka.La35Street.domain.Purchase.values;

import co.com.sofka.domain.generic.Identity;

public class ProductId extends Identity {
    private ProductId(String uuid){
        super(uuid);
    }
    public static ProductId of(String uuid){
        return new ProductId(uuid);
    }
}
