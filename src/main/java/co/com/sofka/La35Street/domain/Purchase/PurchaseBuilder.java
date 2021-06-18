package co.com.sofka.La35Street.domain.Purchase;

import co.com.sofka.La35Street.domain.Purchase.values.ClientId;
import co.com.sofka.La35Street.domain.Purchase.values.IsCancelled;
import co.com.sofka.La35Street.domain.Purchase.values.PurchaseDate;
import co.com.sofka.La35Street.domain.Purchase.values.PurchasePrice;

import java.util.List;

public final class PurchaseBuilder {
    protected PurchasePrice purchasePrice;
    protected PurchaseDate purchaseDate;
    protected ClientId clientId;
    protected List<Product> product;
    protected IsCancelled cancelled;

    private PurchaseBuilder(){
    }



}
