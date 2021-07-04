package co.com.sofka.La35Street.controller;

import co.com.sofka.La35Street.domain.Purchase.commands.EditPurchase;
import co.com.sofka.La35Street.domain.useCase.EditPurchaseUseCase;
import co.com.sofka.La35Street.domain.useCase.PurchaseTransformUseCase;
import co.com.sofka.La35Street.repository.PurchaseData;
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
    private CreatePurchaseUseCase createPurchaseUseCase;

    @Autowired
    private EditPurchaseUseCase editPurchaseUseCase;

    @Autowired
    private PurchaseTransformUseCase purchaseTransformUseCase;

    @PostMapping(value = "api/save/{purchaseId}/{clientId}/{productId}/{brand}/{productName}/{productPrice}")
    public String save(@PathVariable("purchaseId")String purchaseId,
                       @PathVariable("clientId")String clientId,
                       @PathVariable("productId")String productId,
                       @PathVariable("brand")String brand,
                       @PathVariable("productName")String productName,
                       @PathVariable("productPrice")Integer productPrice) {
        Product product = new Product(ProductId.of(productId), new Brand(brand), new ProductName(productName), new ProductPrice(productPrice),new PurchaseId(purchaseId));

        List<Product> productList = new ArrayList<>();
        productList.add(product);

        AddPurchase command = new AddPurchase(PurchaseId.of(purchaseId), new ClientId(clientId), productList);

        CreatePurchaseUseCase.Response purchaseCreated = executedUseCase(command);

        String string = "{"
                + "\"purchaseId\":" + "\"" + purchaseCreated.getPurchase().Id() + "\"" + ","
                + "\"purchasePrice\":" + "\"" + purchaseCreated.getPurchase().PurchasePrice().value() + "\"" + ","
                + "\"purchaseDate\":" + "\"" + purchaseCreated.getPurchase().PurchaseDate().value() + "\"" + ","
                + "\"clientId\":" + "\"" + purchaseCreated.getPurchase().ClientId().value() + "\"" + ","
                + "\"product\": [ " + "\"productId\":" + "\"" + productId + "\"" + ","
                + "\"brand\":" + "\"" + brand + "\"" + ","
                + "\"productName\":" + "\"" + productName +"\""+ ","
                + "\"productPrice\":" + "\"" + productPrice +"\""+ ","
                +"]"
                +"}";

        return string;
    }

    private CreatePurchaseUseCase.Response executedUseCase(AddPurchase command) {
        CreatePurchaseUseCase.Response events = UseCaseHandler.getInstance()
                .syncExecutor(createPurchaseUseCase, new RequestCommand<>(command))
                .orElseThrow();
        CreatePurchaseUseCase.Response PurchaseCreated = events;
        return PurchaseCreated;
    }

    @PutMapping(value = "api/edit/{purchaseId}/{clientId}/{productId}/{brand}/{productName}/{productPrice}")
    public String edit(@PathVariable("purchaseId")String purchaseId,
                       @PathVariable("clientId")String clientId,
                       @PathVariable("productId")String productId,
                       @PathVariable("brand")String brand,
                       @PathVariable("productName")String productName,
                       @PathVariable("productPrice")Integer productPrice) {
        Product product = new Product(ProductId.of(productId), new Brand(brand), new ProductName(productName), new ProductPrice(productPrice),new PurchaseId(purchaseId));

        List<Product> productList = new ArrayList<>();
        productList.add(product);

        EditPurchase command = new EditPurchase(PurchaseId.of(purchaseId), new ClientId(clientId), productList);

        EditPurchaseUseCase.Response purchaseEdited = executedEditPurchaseUseCase(command);

        String string = "{"
                + "\"purchaseId\":" + "\""+purchaseEdited.getPurchase().Id()+"\""+ ","
                + "\"purchasePrice\":" + "\""+purchaseEdited.getPurchase().PurchasePrice().value()+"\""+ ","
                + "\"purchaseDate\":" + "\""+purchaseEdited.getPurchase().PurchaseDate().value()+"\""+ ","
                + "\"clientId\":" + "\""+purchaseEdited.getPurchase().ClientId().value()+"\""+ ","
                + "\"product\": [ " + "\"productId\":" + "\"" + productId + "\"" + ","
                + "\"brand\":" + "\"" + brand + "\"" + ","
                + "\"productName\":" + "\"" + productName +"\""+ ","
                + "\"productPrice\":" + "\"" + productPrice +"\""+ ","
                +"]"
                +"}";

        return string;
    }

    private EditPurchaseUseCase.Response executedEditPurchaseUseCase(EditPurchase command) {
        EditPurchaseUseCase.Response events = UseCaseHandler.getInstance()
                .syncExecutor(editPurchaseUseCase, new RequestCommand<>(command))
                .orElseThrow();
        EditPurchaseUseCase.Response PurchaseEdited = events;
        return PurchaseEdited;
    }

    @GetMapping(value = "api/findPurchase")
    public Iterable<PurchaseData> list(){
        return purchaseTransformUseCase.list();
    }

    @GetMapping(value = "api/findPurchase/{purchaseId}")
    public PurchaseData listId(@PathVariable("purchaseId") String id){
        return purchaseTransformUseCase.listId(id);
    }

    @DeleteMapping(value = "api/delete/{purchaseId}")
    public String delete(@PathVariable("purchaseId") String id){
        return purchaseTransformUseCase.delete(id);
    }

}
