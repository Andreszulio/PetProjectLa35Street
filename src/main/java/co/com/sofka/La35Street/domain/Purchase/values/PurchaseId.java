package co.com.sofka.La35Street.domain.Purchase.values;

import co.com.sofka.domain.generic.Identity;

public class PurchaseId extends Identity {
    public PurchaseId(String Id){
        super(Id);
    }
    public static PurchaseId of(String Id){
        return new PurchaseId(Id);
    }
}
