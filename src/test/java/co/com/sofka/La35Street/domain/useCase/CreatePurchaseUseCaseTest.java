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
        var command = new AddPurchase(PurchaseId.of("123"), ClientId.of("567"), List.of(
                new Product(ProductId.of("23-34"), new Brand("Nike"), new ProductName("Tennis"), new ProductPrice(129999),new PurchaseId("9090")),
                new Product(ProductId.of("24-35"), new Brand("Nike"), new ProductName("Tennis"), new ProductPrice(149999),new PurchaseId("8090")),
                new Product(ProductId.of("25-36"), new Brand("Adidas"), new ProductName("Camiseta"), new ProductPrice(39000),new PurchaseId("7090"))
        ));
        var usecase = new CreatePurchaseUseCase();

        Assertions.assertEquals("123",command.PurchaseId().value());
        Assertions.assertEquals("567",command.ClientId().value());
        Assertions.assertNotNull(command.ProductList());
    }
}