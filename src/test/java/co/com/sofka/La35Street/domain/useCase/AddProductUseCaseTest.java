package co.com.sofka.La35Street.domain.useCase;

import co.com.sofka.La35Street.domain.Purchase.commands.AddProduct;
import co.com.sofka.La35Street.domain.Purchase.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddProductUseCaseTest {
    @Test
    void addAProduct(){
        AddProduct command = new AddProduct(ProductId.of("785"),new Brand("Nike"), new ProductPrice(90000), new ProductName("Tenis"), PurchaseId.of("980"), new Image("https"));

        AddProductUseCase usecase = new AddProductUseCase();
        Assertions.assertEquals("785",command.ProductId().value());
        Assertions.assertEquals("980",command.PurchaseId().value());
    }
}
