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
        var command = new EditPurchase(PurchaseId.of("760"),ClientId.of("9090"), List.of(
                new Product(ProductId.of("23-34"), new Brand("Nike"), new ProductName("Tennis"), new ProductPrice(129999)),
                new Product(ProductId.of("24-35"), new Brand("Nike"), new ProductName("Tennis"), new ProductPrice(149999)),
                new Product(ProductId.of("25-36"), new Brand("Adidas"), new ProductName("Camiseta"), new ProductPrice(39000))
        ));
        var usecase = new EditPurchaseUseCaseTest();
        Assertions.assertEquals("760",command.PurchaseId().value());
        Assertions.assertNotNull(command.Product());
    }
}
