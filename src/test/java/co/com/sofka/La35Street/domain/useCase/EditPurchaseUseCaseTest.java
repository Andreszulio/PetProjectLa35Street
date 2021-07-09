package co.com.sofka.La35Street.domain.useCase;

import co.com.sofka.La35Street.domain.Purchase.Product;
import co.com.sofka.La35Street.domain.Purchase.commands.EditPurchase;
import co.com.sofka.La35Street.domain.Purchase.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EditPurchaseUseCaseTest {
    @Test
    void editAPurchase(){
        EditPurchase command = new EditPurchase(PurchaseId.of("760"),ClientId.of("9090"));
        EditPurchaseUseCase usecase = new EditPurchaseUseCase();
        Assertions.assertEquals("760",command.PurchaseId().value());
    }
}
