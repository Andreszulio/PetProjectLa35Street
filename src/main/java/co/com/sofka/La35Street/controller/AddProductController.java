package co.com.sofka.La35Street.controller;

import co.com.sofka.La35Street.domain.Purchase.Product;
import co.com.sofka.La35Street.domain.Purchase.commands.AddProduct;
import co.com.sofka.La35Street.domain.Purchase.values.*;
import co.com.sofka.La35Street.domain.useCase.AddProductUseCase;
import co.com.sofka.La35Street.domain.useCase.ProductTransformUseCase;
import co.com.sofka.La35Street.repository.ProductData;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class AddProductController {

    @Autowired
    private AddProductUseCase addProductUseCase;

    @Autowired
    private ProductTransformUseCase productTransformUseCase;

    @PostMapping(value = "api/save/{productId}/{brand}/{productPrice}/{productName}/{purchaseId}")
    public String save(@PathVariable("productId") String productId,
                       @PathVariable("brand") String brand,
                       @PathVariable("productPrice") Integer productPrice,
                       @PathVariable("productName") String productName,
                       @PathVariable("purchaseId") String purchaseId) {
        Product product = new Product(ProductId.of(productId), new Brand(brand), new ProductName(productName), new ProductPrice(productPrice), new PurchaseId(purchaseId));

        AddProduct command = new AddProduct(ProductId.of(productId), new Brand(brand), new ProductPrice(productPrice), new ProductName(productName), new PurchaseId(purchaseId));

        AddProductUseCase.Response productAdded = executedUseCase(command);

        String string = "{"
                + "\"productId\":" + "\"" + productAdded.getProduct().Id() + "\"" + ","
                + "\"brand\":" + "\"" + productAdded.getProduct().Brand() + "\"" + ","
                + "\"productPrice\":" + "\"" + productAdded.getProduct().productPrice() + "\"" + ","
                + "\"productName\":" + "\"" + productAdded.getProduct().ProductName() + "\"" + ","
                + "\"purchaseId\":" + "\"" + productAdded.getProduct().PurchaseId() + "\"" + ","
                + "}";

        return string;
    }

    private AddProductUseCase.Response executedUseCase(AddProduct command){
        AddProductUseCase.Response events = UseCaseHandler.getInstance()
                .syncExecutor(addProductUseCase, new RequestCommand<>(command))
                .orElseThrow();
        AddProductUseCase.Response ProductAdded = events;
        return ProductAdded;
    }

    @GetMapping(value = "api/findProduct")
    public Iterable<ProductData> list(){
        return productTransformUseCase.list();
    }

    @GetMapping(value = "api/findProduct/{productId}")
    public ProductData listId(@PathVariable("productId") String id){
        return productTransformUseCase.listId(id);
    }

    @DeleteMapping(value = "api/delete/{productId}")
    public String delete(@PathVariable("productId") String id){
        return productTransformUseCase.delete(id);
    }
    
}
