package co.com.sofka.La35Street.domain.Purchase.values;

import co.com.sofka.domain.generic.Identity;

public class ProductId extends Identity {
    private ProductId(String id){
        super(id);
    }
    public static ProductId of(String id){
        return new ProductId(id);
    }
}
