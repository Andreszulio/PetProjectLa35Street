package co.com.sofka.La35Street.repository;

import co.com.sofka.La35Street.domain.Purchase.Product;
import co.com.sofka.La35Street.domain.Purchase.values.ClientId;
import co.com.sofka.La35Street.domain.Purchase.values.IsCancelled;
import co.com.sofka.La35Street.domain.Purchase.values.PurchaseDate;
import co.com.sofka.La35Street.domain.Purchase.values.PurchasePrice;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Purchase")
public class PurchaseData {
    @Id
    protected PurchasePrice purchasePrice;
    protected PurchaseDate purchaseDate;
    protected ClientId clientId;
    protected List<Product> product;
    protected IsCancelled isCancelled;

    public PurchaseData(PurchasePrice purchasePrice, PurchaseDate purchaseDate, ClientId clientId, List<Product> product, IsCancelled isCancelled) {
        this.purchasePrice = purchasePrice;
        this.purchaseDate = purchaseDate;
        this.clientId = clientId;
        this.product = product;
        this.isCancelled = isCancelled;
    }

    public PurchaseData(){
    }


    public PurchasePrice PurchasePrice() {
        return purchasePrice;
    }

    public void PurchasePrice(PurchasePrice purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public PurchaseDate PurchaseDate() {
        return purchaseDate;
    }

    public void PurchaseDate(PurchaseDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public ClientId ClientId() {
        return clientId;
    }

    public void ClientId(ClientId clientId) {
        this.clientId = clientId;
    }

    public List<Product> Product() {
        return product;
    }

    public void Product(List<Product> product) {
        this.product = product;
    }

    public IsCancelled IsCancelled() {
        return isCancelled;
    }

    public void IsCancelled(IsCancelled isCancelled) {
        this.isCancelled = isCancelled;
    }
}
