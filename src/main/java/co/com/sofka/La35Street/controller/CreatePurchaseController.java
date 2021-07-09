package co.com.sofka.La35Street.controller;

import co.com.sofka.La35Street.domain.Purchase.Purchase;
import co.com.sofka.La35Street.domain.Purchase.commands.EditPurchase;
import co.com.sofka.La35Street.domain.useCase.EditPurchaseUseCase;
import co.com.sofka.La35Street.domain.useCase.ProductTransformUseCase;
import co.com.sofka.La35Street.domain.useCase.PurchaseTransformUseCase;
import co.com.sofka.La35Street.repository.ProductData;
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

    @Autowired
    private ProductTransformUseCase productTransformUseCase;

    @PostMapping(value = "api/savePurchase/{purchaseId}/{clientId}")
    public String save(@PathVariable("purchaseId")String purchaseId,
                       @PathVariable("clientId")String clientId) {

        AddPurchase command = new AddPurchase(PurchaseId.of(purchaseId), new ClientId(clientId));

        CreatePurchaseUseCase.Response purchaseCreated = executedUseCase(command);

        String string = "{"
                + "\"purchaseId\":" + "\"" + purchaseCreated.getPurchase().getId() + "\"" + ","
                + "\"purchasePrice\":" + "\"" + purchaseCreated.getPurchase().PurchasePrice().value() + "\"" + ","
                + "\"purchaseDate\":" + "\"" + purchaseCreated.getPurchase().PurchaseDate().value() + "\"" + ","
                + "\"clientId\":" + "\"" + purchaseCreated.getPurchase().ClientId().value() + "\"" + ","
                + "\"product\":"+ "\"" + purchaseCreated.getPurchase().Product() + "\""
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

    @PutMapping(value = "api/editPurchase/{purchaseId}/{clientId}")
    public String edit(@PathVariable("purchaseId")String purchaseId,
                       @PathVariable("clientId")String clientId) {
        EditPurchase command = new EditPurchase(PurchaseId.of(purchaseId), new ClientId(clientId));

        EditPurchaseUseCase.Response purchaseEdited = executedEditPurchaseUseCase(command);

        String string = "{"
                + "\"purchaseId\":" + "\""+purchaseEdited.getPurchase().getId()+"\""+ ","
                + "\"purchasePrice\":" + "\""+purchaseEdited.getPurchase().PurchasePrice().value()+"\""+ ","
                + "\"purchaseDate\":" + "\""+purchaseEdited.getPurchase().PurchaseDate().value()+"\""+ ","
                + "\"clientId\":" + "\""+purchaseEdited.getPurchase().ClientId().value()+"\""+ ","
                + "\"product\":" + purchaseEdited.getPurchase().Product() +"\""
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
    public String listPurchase(){
        Iterable<PurchaseData> purchases = purchaseTransformUseCase.list();
        String string = "{";
        for (PurchaseData purchase: purchases){
            String string2 = showList(purchase);
            string = string + "{"
                    + "\"purchaseId\":" + "\"" + purchase.Idaa() + "\"" + ","
                    + "\"purchasePrice\":" + "\"" + purchase.PurchasePrice()+ "\"" + ","
                    + "\"purchaseDate\":" + "\"" + purchase.PurchaseDate() + "\"" + ","
                    + "\"clientId\":" + "\"" + purchase.ClientId()+ "\"" + ","
                    + "\"product\": ["+ string2 +"]"
                    + "}"+", \n  \n"+"\t";
        }
        string = string + "}";
        return  string;
    }
    public String showList(PurchaseData purchase){
        String string2= "";
        int cont=0;
        for (ProductData product: purchase.Product()) {
            if ((purchase.Product().size()-1)==cont){
                string2 = string2 + "{"
                        + "\"productId\":" + "\"" + product.Id()+ "\"" + ","
                        + "\"productName\":" + "\"" + product.ProductName()+ "\"" + ","
                        + "\"brand\":" + "\"" + product.Brand() + "\"" + ","
                        + "\"productPrice\":" + "\"" + product.ProductPrice()+ "\"" + ","
                        + "\"purchaseId\":"+ "\"" + product.PurchaseId() + "\""
                        + "}";
            }else {
                string2 = string2 + "{"
                        + "\"productId\":" + "\"" + product.Id() + "\"" + ","
                        + "\"productName\":" + "\"" + product.ProductName() + "\"" + ","
                        + "\"brand\":" + "\"" + product.Brand() + "\"" + ","
                        + "\"productPrice\":" + "\"" + product.ProductPrice() + "\"" + ","
                        + "\"purchaseId\":" + "\"" + product.PurchaseId() + "\""
                        + "}" + ", \n  \n" + "\t";
            }
            cont+=1;
        }
        return string2;
    }

    @GetMapping(value = "api/findPurchase/{id}")
    public String listIdPurchase(@PathVariable("id") String id){
        PurchaseData purchase = purchaseTransformUseCase.listId(id);
        String string = "{"
                + "\"purchaseId\":" + "\"" + purchase.Idaa() + "\"" + ","
                + "\"purchasePrice\":" + "\"" + purchase.PurchasePrice()+ "\"" + ","
                + "\"purchaseDate\":" + "\"" + purchase.PurchaseDate() + "\"" + ","
                + "\"clientId\":" + "\"" + purchase.ClientId()+ "\"" + ","
                + "\"product\":"+ "\"" + purchase.Product() + "\""
                + "}";
        return string;
    }

    @DeleteMapping(value = "api/deletePurchase/{id}")
    public String delete(@PathVariable("id") String id){
        return purchaseTransformUseCase.delete(id);
    }

    @GetMapping(value = "api/showProducts/{id}")
    public String show(@PathVariable("id") String id){
        Iterable<ProductData> products = productTransformUseCase.findByPurchaseId(id);
        String string = "{";
        for (ProductData product: products){
            string = string + "{"
                    + "\"productId\":" + "\"" + product.Id() + "\"" + ","
                    + "\"productName\":" + "\"" + product.ProductName()+ "\"" + ","
                    + "\"brand\":" + "\"" + product.Brand() + "\"" + ","
                    + "\"productPrice\":" + "\"" + product.ProductPrice()+ "\"" + ","
                    + "\"purchaseId\":"+ "\"" + product.PurchaseId()+ "\""
                    + "}"+", \n  \n"+"\t";
        }
        string = string + "}";
        return  string;
    }

}
