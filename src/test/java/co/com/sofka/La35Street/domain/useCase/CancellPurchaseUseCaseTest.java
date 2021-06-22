package co.com.sofka.La35Street.domain.useCase;

import co.com.sofka.La35Street.domain.Purchase.commands.CancellPurchase;
import co.com.sofka.La35Street.domain.Purchase.values.IsCancelled;
import co.com.sofka.La35Street.domain.Purchase.values.PurchaseId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CancellPurchaseUseCaseTest {
    @Test
    void cancellAPurchase(){
        var command = new CancellPurchase(PurchaseId.of("980"),new IsCancelled(Boolean.FALSE));

        var usecase = new CancellPurchaseUseCase();

        Assertions.assertEquals("980",command.PurchaseId().value());

    }
}
