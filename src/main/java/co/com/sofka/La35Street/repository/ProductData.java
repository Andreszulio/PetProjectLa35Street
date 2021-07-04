package co.com.sofka.La35Street.repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Product")
public class ProductData {

    @Id
    protected String id;
    
    protected String brand;
    protected String productName;
    protected Integer productPrice;
    protected String purchaseId;

    public ProductData(String id, String brand, String productName, Integer productPrice, String purchaseId) {
        this.id = id;
        this.brand = brand;
        this.productName = productName;
        this.productPrice = productPrice;
        this.purchaseId = purchaseId;
    }

    public String Id() {
        return id;
    }

    public void Id(String id) {
        this.id = id;
    }

    public String Brand() {
        return brand;
    }

    public void Brand(String brand) {
        this.brand = brand;
    }

    public String ProductName() {
        return productName;
    }

    public void ProductName(String productName) {
        this.productName = productName;
    }

    public Integer ProductPrice() {
        return productPrice;
    }

    public void ProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public String PurchaseId() {
        return purchaseId;
    }

    public void PurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }
}
