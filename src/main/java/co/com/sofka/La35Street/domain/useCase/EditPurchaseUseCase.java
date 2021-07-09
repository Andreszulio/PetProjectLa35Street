package co.com.sofka.La35Street.domain.useCase;

import co.com.sofka.La35Street.domain.Purchase.Product;
import co.com.sofka.La35Street.domain.Purchase.Purchase;
import co.com.sofka.La35Street.domain.Purchase.commands.EditPurchase;
import co.com.sofka.La35Street.domain.Purchase.values.PurchasePrice;
import co.com.sofka.La35Street.repository.IPurchaseDataRepository;
import co.com.sofka.La35Street.repository.PurchaseData;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EditPurchaseUseCase extends UseCase<RequestCommand<EditPurchase>, EditPurchaseUseCase.Response> {

    @Autowired
    private IPurchaseDataRepository iPurchaseDataRepository;

    @Override
    public void executeUseCase(RequestCommand<EditPurchase> editPurchaseRequestCommand) {
        EditPurchase command = editPurchaseRequestCommand.getCommand();

        Purchase purchase = new Purchase(command.PurchaseId(),command.PurchaseDate(),command.ClientId());

        iPurchaseDataRepository.save(purchaseTransform(purchase));
        emit().onResponse(new Response(purchase));

    }

    public PurchaseData purchaseTransform(Purchase purchase){
        PurchaseData purchaseData = new PurchaseData(purchase.identity().value(),purchase.PurchasePrice().value(),purchase.PurchaseDate().value(),purchase.ClientId().value());
        return purchaseData;
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

    public static class Response implements UseCase.ResponseValues{

        private Purchase purchase;

        public Response(Purchase purchase){
            this.purchase = purchase;
        }

        public Purchase getPurchase(){
            return purchase;
        }

        public void setPurchase(Purchase purchase) {
            this.purchase = purchase;
        }
    }
}
