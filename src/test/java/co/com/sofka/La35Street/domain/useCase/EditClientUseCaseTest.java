package co.com.sofka.La35Street.domain.useCase;

import co.com.sofka.La35Street.domain.Purchase.commands.EditClient;
import co.com.sofka.La35Street.domain.Purchase.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EditClientUseCaseTest {
    @Test
    void editAClient(){
        var command = new EditClient(ClientId.of("123"), new ClientName("Andrés"),new ClientAdress("Calle 34CC #89-28"),new ClientEmailAdress("andresanchez200319@gmail.com"),new ClientTelephone("4932107"));
        var usecase = new EditClientUseCase();
        Assertions.assertEquals("123",command.ClientId().value());
    }

}
