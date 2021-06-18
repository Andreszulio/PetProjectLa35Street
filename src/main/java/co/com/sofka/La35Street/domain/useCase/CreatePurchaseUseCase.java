package co.com.sofka.La35Street.domain.useCase;

import co.com.sofka.La35Street.domain.Purchase.Product;
import co.com.sofka.La35Street.domain.Purchase.Purchase;
import co.com.sofka.La35Street.domain.Purchase.commands.AddPurchase;
import co.com.sofka.La35Street.domain.Purchase.values.PurchasePrice;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

import java.util.ArrayList;
import java.util.List;

public class CreatePurchaseUseCase extends UseCase<RequestCommand<AddPurchase>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddPurchase> CreateProductRequestCommand) {
        var command = CreateProductRequestCommand.getCommand();
        var purchase = new Purchase(command.PurchaseId(),CalculatePrice(command.ProductList()),command.ClientId(),command.ProductList());
        emit().onResponse(new ResponseEvents(purchase.getUncommittedChanges()));
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
