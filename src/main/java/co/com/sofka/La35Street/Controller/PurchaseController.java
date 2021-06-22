package co.com.sofka.La35Street.Controller;

import co.com.sofka.La35Street.domain.Purchase.commands.AddPurchase;
import co.com.sofka.La35Street.domain.Purchase.values.ClientId;
import co.com.sofka.La35Street.domain.Purchase.values.PurchaseId;
import co.com.sofka.La35Street.domain.useCase.CreatePurchaseUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@CrossOrigin(origins = "*")
public class PurchaseController {

    @Autowired
    private CreatePurchaseUseCase useCase;

    @PostMapping(value = "api/{purchaseId}/{purhasePrice}/{purchaseDate}/{clientId}/{product}")
    public String save(@PathVariable("purchaseId")String purchaseId,
                       @PathVariable("purchasePrice")Integer purchasePrice,
                       @PathVariable("purchaseDate")LocalDateTime purchaseDate,
                       @PathVariable("clientId")String clientId,
                       @PathVariable("product")String product){
        var command = new AddPurchase(PurchaseId.of(purchaseId), new PurchasePrice(purchasePrice))
    }

}
