package co.com.sofka.La35Street.domain.useCase;

import co.com.sofka.La35Street.domain.Purchase.Product;
import co.com.sofka.La35Street.domain.Purchase.Purchase;
import co.com.sofka.La35Street.domain.Purchase.commands.EditPurchase;
import co.com.sofka.La35Street.domain.Purchase.values.PurchasePrice;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

import java.util.ArrayList;
import java.util.List;

public class EditPurchaseUseCase extends UseCase<RequestCommand<EditPurchase>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<EditPurchase> editPurchaseRequestCommand) {
        var command = editPurchaseRequestCommand.getCommand();
        var purchase = Purchase.from(command.PurchaseId(),retrieveEvents());
        var purchaseprice = CalculatePrice(command.Product());
    }
    public PurchasePrice CalculatePrice(List<Product> productList){
        List<Integer> Prices = new ArrayList<>();
        Integer price=0;
        productList.forEach(product->Prices.add(product.productPrice().value()));
        for (Integer element: Prices){
            price+=element;
        }
        return new PurchasePrice(price);
    }
}
