package co.com.sofka.La35Street.repository;

import co.com.sofka.La35Street.domain.Purchase.Product;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "Purchase")
public class PurchaseData {

    @Id
    protected String id;

    protected Integer purchasePrice;
    protected LocalDateTime purchaseDate;
    protected String clientId;
    protected List<Product> product;

    public PurchaseData(String id,Integer purchasePrice, LocalDateTime purchaseDate, String clientId, List<Product> product) {
        this.id = id;
        this.purchasePrice = purchasePrice;
        this.purchaseDate = purchaseDate;
        this.clientId = clientId;
        this.product = product;
    }

    public PurchaseData(){
    }

    public String Id() {
        return id;
    }

    public void Id(String id) {
        this.id = id;
    }

    public Integer PurchasePrice() {
        return purchasePrice;
    }

    public void PurchasePrice(Integer purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public LocalDateTime PurchaseDate() {
        return purchaseDate;
    }

    public void PurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String ClientId() {
        return clientId;
    }

    public void ClientId(String clientId) {
        this.clientId = clientId;
    }

    public List<Product> Product() {
        return product;
    }

    public void Product(List<Product> product) {
        this.product = product;
    }

}
