package co.com.sofka.La35Street.domain.Purchase;

import co.com.sofka.La35Street.domain.Purchase.values.*;

import java.util.List;

public final class PurchaseBuilder {
    protected PurchasePrice purchasePrice;
    protected PurchaseDate purchaseDate;
    protected ClientId clientId;
    protected List<Product> product;
    protected IsCancelled cancelled;

    private PurchaseBuilder(){
    }

    public static PurchaseBuilder aPurchase(){
        return new PurchaseBuilder();
    }
    public PurchaseBuilder withPurchasePrice(PurchasePrice purchasePrice){
        this.purchasePrice = purchasePrice;
        return this;
    }
    public PurchaseBuilder withPurchaseDate(PurchaseDate purchaseDate){
        this.purchaseDate = purchaseDate;
        return this;
    }
    public PurchaseBuilder withClientId(ClientId clientId){
        this.clientId = clientId;
        return this;
    }
    public PurchaseBuilder withProduct(List<Product> product){
        this.product = product;
        return this;
    }
    public PurchaseBuilder withIsCancelled(IsCancelled cancelled){
        this.cancelled = cancelled;
        return this;
    }
    public Purchase build(){
        return new Purchase(null,purchasePrice, purchaseDate,clientId, product, cancelled);
    }
}
