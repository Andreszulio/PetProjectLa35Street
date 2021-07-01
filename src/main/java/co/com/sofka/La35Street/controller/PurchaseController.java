package co.com.sofka.La35Street.controller;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.La35Street.domain.Purchase.Product;
import co.com.sofka.La35Street.domain.Purchase.commands.AddPurchase;
import co.com.sofka.La35Street.domain.Purchase.values.*;
import co.com.sofka.La35Street.domain.useCase.CreatePurchaseUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class PurchaseController {

    @Autowired
    private CreatePurchaseUseCase useCase;

    @PostMapping(value = "api/{purchaseId}/{clientId}/{productId}/{brand}/{productName}/{productPrice}")
    public String save(@PathVariable("purchaseId")String purchaseId,
                       @PathVariable("clientId")String clientId,
                       @PathVariable("productId")String productId,
                       @PathVariable("brand")String brand,
                       @PathVariable("productName")String productName,
                       @PathVariable("productPrice")Integer productPrice) {
        var product = new Product(ProductId.of(productId), new Brand(brand), new ProductName(productName), new ProductPrice(productPrice));

        List<Product> productList = new ArrayList<>();
        productList.add(product);

        var command = new AddPurchase(PurchaseId.of(purchaseId), new ClientId(clientId), productList);
        
        CreatePurchaseUseCase.Response purchaseCreated = executedUseCase(command);
        return(purchaseCreated.getPurchase().PurchasePrice().value()+ " "+ purchaseCreated.getPurchase().PurchaseDate().value()+" "+purchaseCreated.getPurchase().ClientId().value()+" "+purchaseCreated.getPurchase().Product());
    }

    private CreatePurchaseUseCase.Response executedUseCase(AddPurchase command) {
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();
        var PurchaseCreated = events;
        return PurchaseCreated;
    }
}
