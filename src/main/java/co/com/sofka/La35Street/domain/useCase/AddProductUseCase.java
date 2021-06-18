package co.com.sofka.La35Street.domain.useCase;

import co.com.sofka.La35Street.domain.Purchase.Product;
import co.com.sofka.La35Street.domain.Purchase.Purchase;
import co.com.sofka.La35Street.domain.Purchase.commands.AddProduct;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AddProductUseCase extends UseCase<RequestCommand<AddProduct>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddProduct> AddProductRequestCommand) {
        var command = AddProductRequestCommand.getCommand();
        var product = new Product(command.ProductId(), command.Brand(), command.ProductName(),command.ProductPrice());
        var purchase = Purchase.from(command.PurchaseId(),retrieveEvents());
        purchase.AggregateProduct(product);
        emit().onResponse(new ResponseEvents(purchase.getUncommittedChanges()));
    }
}
