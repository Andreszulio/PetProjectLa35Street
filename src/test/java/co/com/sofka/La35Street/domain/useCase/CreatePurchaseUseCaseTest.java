package co.com.sofka.La35Street.domain.useCase;

import co.com.sofka.La35Street.domain.Purchase.Product;
import co.com.sofka.La35Street.domain.Purchase.commands.AddPurchase;
import co.com.sofka.La35Street.domain.Purchase.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CreatePurchaseUseCaseTest {
    @Test
    void createAPurchase(){
        AddPurchase command = new AddPurchase(PurchaseId.of("123"), ClientId.of("567"));
        CreatePurchaseUseCase usecase = new CreatePurchaseUseCase();

        Assertions.assertEquals("123",command.PurchaseId().value());
        Assertions.assertEquals("567",command.ClientId().value());
        Assertions.assertNotNull(command.ProductList());
    }
}