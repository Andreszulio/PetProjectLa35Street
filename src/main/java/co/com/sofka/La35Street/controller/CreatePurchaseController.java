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
public class CreatePurchaseController {

    @Autowired
    private CreatePurchaseUseCase useCase;

    @PostMapping(value = "api/{purchaseId}/{clientId}/{productId}/{brand}/{productName}/{productPrice}")
    public String save(@PathVariable("purchaseId")String purchaseId,
                       @PathVariable("clientId")String clientId,
                       @PathVariable("productId")String productId,
                       @PathVariable("brand")String brand,
                       @PathVariable("productName")String productName,
                       @PathVariable("productPrice")Integer productPrice) {
        Product product = new Product(ProductId.of(productId), new Brand(brand), new ProductName(productName), new ProductPrice(productPrice));

        List<Product> productList = new ArrayList<>();
        productList.add(product);

        AddPurchase command = new AddPurchase(PurchaseId.of(purchaseId), new ClientId(clientId), productList);

        CreatePurchaseUseCase.Response purchaseCreated = executedUseCase(command);

        String string = "{"
                + "\"purchaseId\":" + "\""+purchaseCreated.getPurchase().Id()+"\""+ ","
                + "\"purchasePrice\":" + "\""+purchaseCreated.getPurchase().PurchasePrice().value()+"\""+ ","
                + "\"purchaseDate\":" + "\""+purchaseCreated.getPurchase().PurchaseDate().value()+"\""+ ","
                + "\"clientId\":" + "\""+purchaseCreated.getPurchase().ClientId().value()+"\""+ ","
                + "\"product\":" + "\""+purchaseCreated.getPurchase().Product()
                +"}";

        return string;
    }

    private CreatePurchaseUseCase.Response executedUseCase(AddPurchase command) {
        CreatePurchaseUseCase.Response events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();
        CreatePurchaseUseCase.Response PurchaseCreated = events;
        return PurchaseCreated;
    }

}
